package net.dreamlu.mica.social.request;

import com.fasterxml.jackson.databind.JsonNode;
import net.dreamlu.mica.http.HttpRequest;
import net.dreamlu.mica.social.config.AuthConfig;
import net.dreamlu.mica.social.config.AuthSource;
import net.dreamlu.mica.social.exception.AuthException;
import net.dreamlu.mica.social.model.AuthToken;
import net.dreamlu.mica.social.model.AuthUser;
import net.dreamlu.mica.social.model.AuthUserGender;

/**
 * oschina登录
 *
 * @author L.cm
 */
public class AuthOschinaRequest extends AuthDefaultRequest {

	public AuthOschinaRequest(AuthConfig config) {
		super(config, AuthSource.OSCHINA);
	}

	@Override
	protected AuthToken getAccessToken(String code) {
		JsonNode jsonNode = doPostAuthorizationCode(code).asJsonNode();
		if (jsonNode.has("error")) {
			throw new AuthException("Unable to get token from oschina using code [" + code + "]");
		}
		return AuthToken.builder()
			.accessToken(jsonNode.get("access_token").asText())
			.build();
	}

	@Override
	protected AuthUser getUserInfo(AuthToken authToken) {
		String accessToken = authToken.getAccessToken();
		JsonNode object = HttpRequest.get(authSource.userInfo())
			.queryEncoded("access_token", accessToken)
			.execute()
			.asJsonNode();
		if (object.has("error")) {
			throw new AuthException(object.get("error_description").asText());
		}
		return AuthUser.builder()
			.uuid(object.get("id").asText())
			.username(object.get("name").asText())
			.nickname(object.get("name").asText())
			.avatar(object.at("/avatar").asText())
			.blog(object.at("/url").asText())
			.location(object.at("/location").asText())
			.gender(AuthUserGender.getRealGender(object.at("/gender").asText()))
			.email(object.at("/email").asText())
			.token(authToken)
			.source(authSource)
			.build();
	}
}

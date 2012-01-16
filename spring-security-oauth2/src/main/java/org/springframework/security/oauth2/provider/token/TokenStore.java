package org.springframework.security.oauth2.provider.token;

import org.springframework.security.oauth2.common.ExpiringOAuth2RefreshToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

/**
 * Persistence interface for OAuth2 tokens.
 */
public interface TokenStore {
	/**
	 * Read the authentication stored under the specified token value.
	 * 
	 * @param token The token value under which the authentication is stored.
	 * @return The authentication, or null if none.
	 */
	OAuth2Authentication readAuthentication(OAuth2AccessToken token);

	/**
	 * Store an access token.
	 * 
	 * @param token The token to store.
	 * @param authentication The authentication associated with the token.
	 */
	void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication);

	/**
	 * Read an access token from the store.
	 * 
	 * @param tokenValue The token value.
	 * @return The access token to read.
	 */
	OAuth2AccessToken readAccessToken(String tokenValue);

	/**
	 * Remove an access token from the database.
	 * 
	 * @param tokenValue The token to remove from the database.
	 */
	void removeAccessToken(String tokenValue);

	/**
	 * Read the authentication stored under the specified token value.
	 * 
	 * @param token The token value under which the authentication is stored.
	 * @return The authentication, or null if none.
	 */
	OAuth2Authentication readAuthentication(ExpiringOAuth2RefreshToken token);

	/**
	 * Store the specified refresh token in the database.
	 * 
	 * @param refreshToken The refresh token to store.
	 * @param authentication The authentication associated with the refresh token.
	 */
	void storeRefreshToken(ExpiringOAuth2RefreshToken refreshToken, OAuth2Authentication authentication);

	/**
	 * Read a refresh token from the store.
	 * 
	 * @param tokenValue The value of the token to read.
	 * @return The token.
	 */
	ExpiringOAuth2RefreshToken readRefreshToken(String tokenValue);

	/**
	 * Remove a refresh token from the database.
	 * 
	 * @param tokenValue The value of the token to remove from the database.
	 */
	void removeRefreshToken(String tokenValue);

	/**
	 * Remove an access token using a refresh token. This functionality is necessary so refresh tokens can't be used to
	 * create an unlimited number of access tokens.
	 * 
	 * @param refreshToken The refresh token.
	 */
	void removeAccessTokenUsingRefreshToken(String refreshToken);

	/**
	 * Retrieve an access token stored against the provided authentication key, if it exists.
	 * 
	 * @param authentication the authentication key for the access token
	 * 
	 * @return the access token or null if there was none
	 */
	OAuth2AccessToken getAccessToken(OAuth2Authentication authentication);
}

export const oktaConfig = {
    clientId: '0oakug75x0IvNZVvq5d7',
    issuer: 'https://dev-17339499.okta.com/oauth2/default',
    redirectUri: 'http://localhost:3000/login/callback',
    scopes: ['openid', 'profile', 'email'],
    pkce: true,
    disableHttpsCheck: true,
}
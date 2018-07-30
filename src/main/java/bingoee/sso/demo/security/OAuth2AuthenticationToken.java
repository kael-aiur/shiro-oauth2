package bingoee.sso.demo.security;

import net.bingosoft.oss.ssoclient.model.AccessToken;
import net.bingosoft.oss.ssoclient.model.Authentication;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

/**
 * @author kael.
 */
public class OAuth2AuthenticationToken implements AuthenticationToken, AuthenticationInfo {

    private static final long serialVersionUID = -524114034230988371L;
    protected final Authentication authentication;
    protected final AccessToken accessToken;
    protected final PrincipalCollection principalCollection;

    public OAuth2AuthenticationToken(Authentication authentication, AccessToken accessToken) {
        this.authentication = authentication;
        this.accessToken = accessToken;
        this.principalCollection = new SimplePrincipalCollection();
        ((SimplePrincipalCollection) this.principalCollection).add(authentication.getUsername(),"username");
        ((SimplePrincipalCollection) this.principalCollection).add(authentication.getUserId(),"userId");
    }

    @Override
    public Object getPrincipal() {
        return authentication.getUsername();
    }

    @Override
    public Object getCredentials() {
        return accessToken;
    }

    @Override
    public PrincipalCollection getPrincipals() {
        return principalCollection;
    }
}

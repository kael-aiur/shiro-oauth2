package bingoee.sso.demo.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.AuthenticatingRealm;

/**
 * @author kael.
 */
public class OAuth2AuthenticationRealm extends AuthenticatingRealm {
    
    {
        setAuthenticationTokenClass(OAuth2AuthenticationToken.class);
    }
    
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if(token instanceof AuthenticationInfo){
            return (AuthenticationInfo) token;
        }
        throw new AuthenticationException("unsupported token type " + token.getClass());
    }
}

package com.guyue.common.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * shiro的登录认证及用户权限加载的实现 必须使用spring创建此类的实例
* @ClassName: AccessAuthorizeRealm  
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author huhedong
* @date 2016年12月5日 下午4:34:37 
*
 */
public class AccessAuthorizeRealm extends AuthorizingRealm {

	/**
	 * 授权信息加载
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
//		String username = (String) principals.fromRealm(getName()).iterator()
//				.next();
//		List<String> roles = new ArrayList<String>();
//		List<String> priv = new ArrayList<String>();
//		if (!username.equals("guyue")) {
//			throw new UnknownAccountException("用户不存在");
//		}
//		// 准备向shrio返回用户的权限信息
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.addRoles(roles);
//		info.addStringPermissions(priv);
		return null;
	}

	/**
	 * 登录认证
	 * 
	 * @param token
	 *            即使用SecurityUtils.getSubject().login()方法做登录认证时传进来的类型
	 *            在UserApi.login方法上传入了UsernamePasswordToken类型, 所以此token可以用这个类型拆箱
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		String username = loginToken.getUsername();
		String password = new String(loginToken.getPassword());
		if (username.equals("guyue") && password.equals("123456")) {
			return new SimpleAuthenticationInfo(username, password, getName());
		} else {
			throw new UnknownAccountException("用户不存在");
		}
	}
}

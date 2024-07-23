package www.ecom.service;

import javax.management.relation.Role;
import java.util.List;
public interface RoleService {
	
	public Role createRole(Role role);
	
	public List<Role> getAllRoles(Role role);
	
	public Role getRoleById(Integer roleId);
	
	public Role deleteRoleById(Integer roleId);
	
	
	
	

}

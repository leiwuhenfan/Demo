package ink.zhongshao.reduucefor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestHHG {

	public static void main(String[] args) {

		// 递归变成循环

		List<Organization> allOrgs = new ArrayList<Organization>();

		Organization rootOrg = new Organization();
		rootOrg.setDeptId("0");
		rootOrg.setParentDeptId(null);
		allOrgs.add(rootOrg);

		Organization org1 = new Organization();
		org1.setDeptId("1");
		org1.setParentDeptId("0");
		allOrgs.add(org1);

		Organization org2 = new Organization();
		org2.setDeptId("2");
		org2.setParentDeptId("1");
		allOrgs.add(org2);

		Organization org3 = new Organization();
		org3.setDeptId("3");
		org3.setParentDeptId("0");
		allOrgs.add(org3);

		

		Organization currentOrg = new Organization();
		currentOrg.setDeptId("2");
		currentOrg.setParentDeptId("1");
		
		List<Organization> result1 = new ArrayList<>();
		build(currentOrg, result1, allOrgs);
		result1.forEach((o) -> {System.out.println("=" + o.getDeptId() + "   " + o.getParentDeptId());});
		
		System.out.println("------------------------------------");
		
		List<Organization> result2 = new ArrayList<>();
		buildfor(currentOrg, result2, allOrgs);
		result2.forEach((o) -> {System.out.println("=" + o.getDeptId() + "   " + o.getParentDeptId());});

	}

	/**
	 * 循环
	 * 
	 * @param organization
	 * @param result
	 * @param allOrgs
	 */
	public static void buildfor(Organization organization, List<Organization> result, List<Organization> allOrgs) {
		int deph = 0;
		for(;;){
			if(deph > 10) {
				return;
			}
			deph++;
			Organization newOrg = new Organization();
			newOrg.setDeptId(organization.getDeptId());
			newOrg.setParentDeptId(organization.getParentDeptId());
			
			result.add(newOrg);
			if (organization != null && organization.getParentDeptId() != null) {
				Optional<Organization> orgOption = allOrgs.stream().filter((org) -> {
					return org.getDeptId().equals(organization.getParentDeptId());
				}).findAny();
				if (orgOption.isPresent()) {
					organization.setDeptId(orgOption.get().getDeptId());
					organization.setParentDeptId(orgOption.get().getParentDeptId());
					continue;
				}
			}else{
				break;
			}
		}
	}

	/**
	 * 递归
	 * 
	 * @param organization
	 * @param result
	 * @param allOrgs
	 */
	public static void build(Organization organization, List<Organization> result, List<Organization> allOrgs) {

//		System.out.println("===============" + organization.getDeptId() + "   " + organization.getParentDeptId());

		result.add(organization);
		if (organization != null && organization.getParentDeptId() != null) {
			Optional<Organization> orgOption = allOrgs.stream().filter((org) -> {
				return org.getDeptId().equals(organization.getParentDeptId());
			}).findAny();
			if (orgOption.isPresent()) {
				build(orgOption.get(), result, allOrgs);
			}
		}
	}
}

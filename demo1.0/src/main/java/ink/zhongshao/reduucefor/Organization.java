package ink.zhongshao.reduucefor;

public class Organization {

	public Organization() {
	}

	private Long id;

	private String name;

	private String deptId;
	/**
	 * �Ƿ�Ϊ���ڵ�
	 */

	private Long isRootState;
	/**
	 * ��֯����������
	 */

	private Long roleType;
	/**
	 * ������֯����
	 */
	private String parentDeptId;

	/**
	 * �Ƿ���Ҷ�ӽڵ�
	 */
	private Long isLeafState;
	/**
	 * ��ʷ����
	 */
	private String historyName;
	/**
	 * ������Դ
	 */
	private String dataSources;
	/**
	 * ְ������
	 */
	private String responsibilityDescribe;
	/**
	 * ���
	 */
	private String intro;
	/**
	 * Ӣ������
	 */
	private String englishName;
	/**
	 * Ӣ����
	 */
	private String englishIntro;
	/**
	 * ��������
	 */
	private String establishDate;
	/**
	 * ����������
	 */
	private String otherPrincipalName;
	/**
	 * ������
	 */
	private String principalName;
	/**
	 * ����ʱ��
	 */
	private String createDate;
	/**
	 * �޸�ʱ��
	 */
	private String modifyDate;
	/**
	 * ״̬
	 */
	private String state;

	/**
	 * ��ȡ���
	 * 
	 * @return ���
	 */
	public Long getId() {
		return id;
	}

	/**
	 * �������
	 * 
	 * @param id ���
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * ��ȡ��֯�ṹ������
	 * 
	 * @return ��֯�ṹ������
	 */
	public String getName() {
		return name;
	}

	/**
	 * ������֯�ṹ������
	 * 
	 * @param name ��Ҫ���õ���֯�ṹ������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * �Ƿ��Ǹ��ڵ�
	 * 
	 * @return ���ڵ�
	 */
	public Long getIsRootState() {
		return isRootState;
	}

	/**
	 * ����Ϊ���ڵ�
	 * 
	 * @param isRootState �Ƿ��Ǹ��ڵ�
	 */
	public void setIsRootState(Long isRootState) {
		this.isRootState = isRootState;
	}

	/**
	 * ��ȡ��֯�ṹ������
	 * 
	 * @return ��֯�ṹ������
	 */
	public Long getRoleType() {
		return roleType;
	}

	/**
	 * ������֯�ṹ������
	 * 
	 * @param type ��Ҫ���õ���֯����������
	 */
	public void setRoleType(Long roleType) {
		this.roleType = roleType;
	}

	/**
	 * ��ȡ��λ���
	 * 
	 * @return ��λ���
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * ���õ�λ���
	 * 
	 * @param deptId ��λ���
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * ��ȡ�������ű��
	 * 
	 * @return �������ű��
	 */
	public String getParentDeptId() {
		return parentDeptId;
	}

	/**
	 * ���ø������ű��
	 * 
	 * @param parentDeptId �������ű��
	 */
	public void setParentDeptId(String parentDeptId) {
		this.parentDeptId = parentDeptId;
	}

	/**
	 * ��ȡ�ӽڵ��״̬
	 * 
	 * @return �ӽڵ�״̬
	 */
	public Long getIsLeafState() {
		return isLeafState;
	}

	/**
	 * �����Ƿ����ӽڵ��״̬
	 * 
	 * @param isLeafState �ӽڵ��״̬��1�������ӽڵ㣬0�������ӽڵ�
	 */
	public void setIsLeafState(Long isLeafState) {
		this.isLeafState = isLeafState;
	}

	/**
	 * ��ȡ��ʷ����
	 * 
	 * @return ��ʷ����
	 */
	public String getHistoryName() {
		return historyName;
	}

	/**
	 * ������ʷ����
	 * 
	 * @param historyName ��ʷ����
	 */
	public void setHistoryName(String historyName) {
		this.historyName = historyName;
	}

	/**
	 * ��ȡ������Դ
	 * 
	 * @return ������Դ
	 */
	public String getDataSources() {
		return dataSources;
	}

	/**
	 * ����������Դ
	 * 
	 * @param dataSources ������Դ
	 */
	public void setDataSources(String dataSources) {
		this.dataSources = dataSources;
	}

	/**
	 * ��ȡְ������
	 * 
	 * @return ְ������
	 */
	public String getResponsibilityDescribe() {
		return responsibilityDescribe;
	}

	/**
	 * ����ְ������
	 * 
	 * @param responsibilityDescribe ְ������
	 */
	public void setResponsibilityDescribe(String responsibilityDescribe) {
		this.responsibilityDescribe = responsibilityDescribe;
	}

	/**
	 * ��ȡ���
	 * 
	 * @return ���
	 */
	public String getIntro() {
		return intro;
	}

	/**
	 * ���ü��
	 * 
	 * @param intro ��Ҫ���õļ��
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/**
	 * ��ȡӢ������
	 * 
	 * @return Ӣ������
	 */
	public String getEnglishName() {
		return englishName;
	}

	/**
	 * ����Ӣ������
	 * 
	 * @param englishName ��Ҫ���õ�Ӣ������
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	/**
	 * ��ȡ����ʱ��
	 * 
	 * @return ����ʱ��
	 */
	public String getEstablishDate() {
		return establishDate;
	}

	/**
	 * ���ó���ʱ��
	 * 
	 * @param establishDate ����ʱ��
	 */
	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}

	/**
	 * ��ȡ����������
	 * 
	 * @return ����������
	 */
	public String getOtherPrincipalName() {
		return otherPrincipalName;
	}

	/**
	 * ��������������
	 * 
	 * @param otherPrincipalName ����������
	 */
	public void setOtherPrincipalName(String otherPrincipalName) {
		this.otherPrincipalName = otherPrincipalName;
	}

	/**
	 * ��ȡ��������
	 * 
	 * @return ��������
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * ���ô�������
	 * 
	 * @param createDate ��������
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * ��ȡ�޸�����
	 * 
	 * @return �޸�����
	 */
	public String getModifyDate() {
		return modifyDate;
	}

	/**
	 * �����޸ĵ�����
	 * 
	 * @param modifyDate
	 */
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * ��ȡ�޸�״̬
	 * 
	 * @return �޸�״̬
	 */
	public String getState() {
		return state;
	}

	/**
	 * �����޸�״̬
	 * 
	 * @param state �޸ĵ�״̬
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * ��ȡӢ����
	 * 
	 * @return Ӣ����
	 */
	public String getEnglishIntro() {
		return englishIntro;
	}

	/**
	 * ����Ӣ����
	 * 
	 * @param englishIntro Ӣ����
	 */
	public void setEnglishIntro(String englishIntro) {
		this.englishIntro = englishIntro;
	}

	/**
	 * ��ȡ������
	 * 
	 * @return ������
	 */
	public String getPrincipalName() {
		return principalName;
	}

	/**
	 * ���ø�����
	 * 
	 * @param principalName ������
	 */
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

}

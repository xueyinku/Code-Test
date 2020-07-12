package com.xue.cloud.model;

public class BugMes {
	@Override
	public String toString() {
		return "BugMes [id=" + id + ", name=" + name + ", proId=" + proId + ", pheContent=" + pheContent + ", pheId="
				+ pheId + ", stage=" + stage + ", recoro=" + recoro + ", happTime=" + happTime + ", strUser=" + strUser
				+ ", strTime=" + strTime + ", strId=" + strId + ", cause=" + cause + ", confirmid=" + confirmid
				+ ", conTime=" + conTime + ", state=" + state + "]";
	}
	private int id;//bug id
	private String name;// bug name
	private int proId;//��Ŀ���id
	private String pheContent;//bug��������
	private int pheId;//��������id
	private String stage;//�����׶�
	private int recoro;//��¼��id
	private String happTime;//����ʱ��
	private int strUser;//�Բ���
	private String strTime;//�Բ�����
	private int strId;//�Բ�����id
	private String cause;//ԭ��
	private int confirmid;//ȷ����id
	private String conTime;//ȷ��ʱ��
	private int state;//״̬��1.�����У�2�Բ��꣬3ȷ����4�ѹرգ�
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getPheContent() {
		return pheContent;
	}
	public void setPheContent(String pheContent) {
		this.pheContent = pheContent;
	}
	public int getPheId() {
		return pheId;
	}
	public void setPheId(int pheId) {
		this.pheId = pheId;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public int getRecoro() {
		return recoro;
	}
	public void setRecoro(int recoro) {
		this.recoro = recoro;
	}
	public String getHappTime() {
		return happTime;
	}
	public void setHappTime(String happTime) {
		this.happTime = happTime;
	}
	public int getStrUser() {
		return strUser;
	}
	public void setStrUser(int strUser) {
		this.strUser = strUser;
	}
	public String getStrTime() {
		return strTime;
	}
	public void setStrTime(String strTime) {
		this.strTime = strTime;
	}
	public int getStrId() {
		return strId;
	}
	public void setStrId(int strId) {
		this.strId = strId;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public int getConfirmid() {
		return confirmid;
	}
	public void setConfirmid(int confirmid) {
		this.confirmid = confirmid;
	}
	public String getConTime() {
		return conTime;
	}
	public void setConTime(String conTime) {
		this.conTime = conTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
package lotteryaward.common.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class AboutMe implements Serializable {


    private Integer id;

    /**
     * 公告标题
     */
    private String title;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
     * 状态
     * 0 - 禁用
     * 1 - 启用
     */
    private Integer status = 0;
    
    /**
     * 所属站点
     */
    private Integer siteId;
    
    
	/**
     * 标题顺序
     */
    private Integer sort;
    /**
     * 建立时间
     */
    private Date createDate;
    /**
     * 建立者ID
     */
    private Integer createUserId;
    /**
     * 建立者
     */
    private String createUserName;
    
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 修改者ID
     */
    private Integer updateUserId;
    /**
     * 修改者
     */
    private String updateUserName;
    
    /**
     * 内容
     */
    private String content;
}

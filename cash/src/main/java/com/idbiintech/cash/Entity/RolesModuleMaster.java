package com.idbiintech.cash.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ROLES_MODULE_MASTER" )
public class RolesModuleMaster {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "role_module_id" , nullable = false)
	private Integer roleModuleId;
	
	@Column(name = "role_id" , nullable = true)
	private Long roleId;
	
	@Column(name = "module_id" , nullable = true)
	private Integer moduleId;
	
	@Column(name = "add_rights" , nullable = true)
	private Integer add;
	
	@Column(name = "edit_rights" , nullable = true)
	private Integer edit;
	
	@Column(name = "view_rights" , nullable = true)
	private Integer view;
	
	@Column(name = "delete_rights" , nullable = true)
	private Integer deleted;
	
	@Column(name = "created_by" , nullable = true)
	private String createdBy;
	
	@Column(name = "createdDate" , nullable = true)
	private Date createdDate;
	
	@Column(name = "updated_by" , nullable = true)
	private String updatedBy;
	
	@Column(name = "updated_date" , nullable = true)
	private Date updatedDate;
	
	@Column(name = "checker" , nullable = true)
	private Integer checker;
	
	@Column(name = "imports" , nullable = true)
	private Integer imports;
	
	@Column(name = "export" , nullable = true)
	private Integer export;

	
	@Column(name = "sweep_execute" , nullable = true)
	private Integer sweepExecute;
	
	@Column(name = "menu_id" , nullable = true)
	private Integer menuId;
	
	
	@Column(name = "customer_id")
 	private Integer customerId;
	
	@Column(name = "user_type")
	private String userType;
	
	@Column(name="project_id")
	private Integer projectId;
	
	@Column(name="db_version")
	private Integer dbVersion;
	
	@Column(name = "module_name" , nullable = true)
	private String moduleName;

	public Integer getRoleModuleId() {
		return roleModuleId;
	}

	public void setRoleModuleId(Integer roleModuleId) {
		this.roleModuleId = roleModuleId;
	}

	

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getAdd() {
		return add;
	}

	public void setAdd(Integer add) {
		this.add = add;
	}

	public Integer getEdit() {
		return edit;
	}

	public void setEdit(Integer edit) {
		this.edit = edit;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getChecker() {
		return checker;
	}

	public void setChecker(Integer checker) {
		this.checker = checker;
	}

	public Integer getImports() {
		return imports;
	}

	public void setImports(Integer imports) {
		this.imports = imports;
	}

	public Integer getExport() {
		return export;
	}

	public void setExport(Integer export) {
		this.export = export;
	}

	public Integer getSweepExecute() {
		return sweepExecute;
	}

	public void setSweepExecute(Integer sweepExecute) {
		this.sweepExecute = sweepExecute;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getDbVersion() {
		return dbVersion;
	}

	public void setDbVersion(Integer dbVersion) {
		this.dbVersion = dbVersion;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	
	
}

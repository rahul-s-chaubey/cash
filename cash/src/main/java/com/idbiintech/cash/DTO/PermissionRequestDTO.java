package com.idbiintech.cash.DTO;

public class PermissionRequestDTO {

	private Integer moduleId;
	
	private Integer add;

	private Integer edit;

	private Integer view;

	private Integer deleted;
	private Integer checker;

	private Integer imports;

	private Integer export;

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

	
}

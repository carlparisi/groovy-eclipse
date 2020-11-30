/*******************************************************************************
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.codehaus.groovy.eclipse.wizards;

import org.eclipse.osgi.util.NLS;

public final class NewWizardMessages extends NLS {

	private static final String BUNDLE_NAME= "org.codehaus.groovy.eclipse.wizards.NewWizardMessages";//$NON-NLS-1$

	private NewWizardMessages() {
		// Do not instantiate
	}

	public static String AbstractOpenWizardAction_noproject_title;
	public static String AbstractOpenWizardAction_noproject_message;
	public static String AbstractOpenWizardAction_createerror_title;
	public static String AbstractOpenWizardAction_createerror_message;
	public static String AddArchiveToBuildpathAction_DuplicateArchiveInfo_message;
	public static String AddArchiveToBuildpathAction_DuplicateArchivesInfo_message;
	public static String AddArchiveToBuildpathAction_ErrorTitle;
	public static String AddArchiveToBuildpathAction_InfoTitle;
	
	public static String AddLibraryToBuildpathAction_ErrorTitle;
	
	public static String AddSelectedLibraryToBuildpathAction_ErrorTitle;
	
	public static String AddSourceFolderToBuildpathAction_ErrorTitle;
	
	public static String AddSourceFolderWizardPage_description;	
	public static String AddSourceFolderWizardPage_addSinglePattern;
	public static String AddSourceFolderWizardPage_conflictWarning;
	public static String AddSourceFolderWizardPage_ignoreNestingConflicts;
	public static String AddSourceFolderWizardPage_replaceSourceFolderInfo;
	public static String BuildPathsBlock_RemoveOldOutputFolder_description;
	public static String BuildPathSupport_deprecated;
	public static String CPListLabelProvider_attribute_label;
	public static String CPVariableElementLabelProvider_appendix;
	public static String CPVariableElementLabelProvider_deprecated;
	public static String CPVariableElementLabelProvider_one_restriction;
	public static String CPVariableElementLabelProvider_read_only;
	public static String CPVariableElementLabelProvider_two_restrictions;
	
	public static String EditOutputFolderAction_DeleteOldOutputFolderQuestion;
	public static String EditOutputFolderAction_ErrorDescription;
	public static String EditOutputFolderAction_ProgressMonitorDescription;
	
	public static String ExcludeFromBuildathAction_ErrorTitle;
	
	public static String IncludeToBuildpathAction_ErrorTitle;
	public static String JavaProjectWizardFirstPage_DetectGroup_differendWorkspaceCC_message;
	public static String JavaProjectWizardFirstPage_EnableWorkingSet_button;
	public static String JavaProjectWizardFirstPage_JREGroup_specific_EE;
	public static String JavaProjectWizardFirstPage_Message_existingFolderInWorkspace;
	public static String JavaProjectWizardFirstPage_Message_invalidProjectNameForWorkspaceRoot;
	public static String JavaProjectWizardFirstPage_Message_notExisingProjectOnWorkspaceRoot;
	public static String JavaProjectWizardFirstPage_Message_notOnWorkspaceRoot;
	public static String JavaProjectWizardFirstPage_NoJREFound_link;
	public static String JavaProjectWizardFirstPage_UnknownDefaultJRE_name;
	public static String JavaProjectWizardFirstPage_WorkingSets_group;
	public static String JavaProjectWizardFirstPage_WorkingSetSelection_message;
	public static String JavaProjectWizardSecondPage_DeleteCorruptProjectFile_message;
	
	public static String NewElementWizard_op_error_title;
	public static String NewElementWizard_op_error_message;
	public static String NewElementWizard_typecomment_deprecated_title;
	public static String NewElementWizard_typecomment_deprecated_message;
	
	public static String NewContainerWizardPage_container_label;
	public static String NewContainerWizardPage_container_button;
	public static String NewContainerWizardPage_error_EnterContainerName;
	public static String NewContainerWizardPage_error_ContainerIsBinary;
	public static String NewContainerWizardPage_error_ContainerDoesNotExist;
	public static String NewContainerWizardPage_error_NotAFolder;
	public static String NewContainerWizardPage_error_ProjectClosed;
	public static String NewContainerWizardPage_warning_NotAJavaProject;
	public static String NewContainerWizardPage_warning_NotInAJavaProject;
	public static String NewContainerWizardPage_warning_NotOnClassPath;
	public static String NewContainerWizardPage_ChooseSourceContainerDialog_title;
	public static String NewContainerWizardPage_ChooseSourceContainerDialog_description;
	
	public static String NewPackageCreationWizard_title;
	
	public static String NewPackageWizardPage_package_label;
	public static String NewPackageWizardPage_error_InvalidPackageName;
	public static String NewPackageWizardPage_error_IsOutputFolder;
	public static String NewPackageWizardPage_error_PackageExists;
	public static String NewPackageWizardPage_error_PackageExistsDifferentCase;
	public static String NewPackageWizardPage_error_EnterName;
	public static String NewPackageWizardPage_error_PackageNotShown;
	public static String NewPackageWizardPage_warning_DiscouragedPackageName;
	public static String NewPackageWizardPage_title;
	public static String NewPackageWizardPage_description;
	public static String NewPackageWizardPage_info;
	public static String NewSourceFolderWizardPage_error_ProjectNotOpen;
	
	public static String NewTypeWizardPage_package_label;
	public static String NewTypeWizardPage_package_button;
	public static String NewTypeWizardPage_enclosing_selection_label;
	public static String NewTypeWizardPage_enclosing_field_description;
	public static String NewTypeWizardPage_enclosing_button;
	public static String NewTypeWizardPage_error_InvalidPackageName;
	public static String NewTypeWizardPage_error_ClashOutputLocation;
	public static String NewTypeWizardPage_warning_DiscouragedPackageName;
	public static String NewTypeWizardPage_warning_DefaultPackageDiscouraged;
	public static String NewTypeWizardPage_warning_NotJDKCompliant;
	public static String NewTypeWizardPage_warning_EnumClassNotFound;
	public static String NewTypeWizardPage_default;
	public static String NewTypeWizardPage_ChoosePackageDialog_title;
	public static String NewTypeWizardPage_ChoosePackageDialog_description;
	public static String NewTypeWizardPage_ChoosePackageDialog_empty;
	public static String NewTypeWizardPage_ChooseEnclosingTypeDialog_title;
	public static String NewTypeWizardPage_ChooseEnclosingTypeDialog_description;
	public static String NewTypeWizardPage_error_EnclosingTypeEnterName;
	public static String NewTypeWizardPage_error_EnclosingTypeNotExists;
	public static String NewTypeWizardPage_error_EnclosingNotInCU;
	public static String NewTypeWizardPage_error_EnclosingNotEditable;
	public static String NewTypeWizardPage_warning_EnclosingNotInSourceFolder;
	public static String NewTypeWizardPage_typename_label;
	public static String NewTypeWizardPage_superclass_label;
	public static String NewTypeWizardPage_superclass_button;
	public static String NewTypeWizardPage_interfaces_class_label;
	public static String NewTypeWizardPage_interfaces_ifc_label;
	public static String NewTypeWizardPage_interfaces_add;
	public static String NewTypeWizardPage_interfaces_remove;
	public static String NewTypeWizardPage_modifiers_acc_label;
	public static String NewTypeWizardPage_modifiers_public;
	public static String NewTypeWizardPage_modifiers_private;
	public static String NewTypeWizardPage_modifiers_protected;
	public static String NewTypeWizardPage_modifiers_default;
	public static String NewTypeWizardPage_modifiers_abstract;
	public static String NewTypeWizardPage_modifiers_final;
	public static String NewTypeWizardPage_modifiers_static;
	public static String NewTypeWizardPage_addcomment_label;
	public static String NewTypeWizardPage_addcomment_description;
	public static String NewTypeWizardPage_error_EnterTypeName;
	public static String NewTypeWizardPage_error_TypeNameExists;
	public static String NewTypeWizardPage_error_TypeNameExistsDifferentCase;
	public static String NewTypeWizardPage_error_InvalidTypeName;
	public static String NewTypeWizardPage_error_QualifiedName;
	public static String NewTypeWizardPage_warning_TypeNameDiscouraged;
	public static String NewTypeWizardPage_error_TypeParameters;
	public static String NewTypeWizardPage_error_InvalidSuperClassName;
	public static String NewTypeWizardPage_error_SuperClassNotParameterized;
	public static String NewTypeWizardPage_error_InvalidSuperInterfaceName;
	public static String NewTypeWizardPage_error_SuperInterfaceNotParameterized;
	public static String NewTypeWizardPage_error_ModifiersFinalAndAbstract;
	public static String NewTypeWizardPage_configure_templates_message;
	public static String NewTypeWizardPage_configure_templates_title;
	public static String NewTypeWizardPage_SuperClassDialog_title;
	public static String NewTypeWizardPage_SuperClassDialog_message;
	public static String NewTypeWizardPage_InterfacesDialog_class_title;
	public static String NewTypeWizardPage_InterfacesDialog_interface_title;
	public static String NewTypeWizardPage_InterfacesDialog_message;
	public static String NewTypeWizardPage_operationdesc;
	public static String NewTypeWizardPage_error_uri_location_unkown;
	
	public static String OutputLocation_DotAsLocation;
	public static String OutputLocation_SettingsAsLocation;
	public static String OutputLocationDialog_removeProjectFromBP;
	
	public static String RemoveFromBuildpathAction_ErrorTitle;
	
	public static String SuperInterfaceSelectionDialog_addButton_label;
	public static String SuperInterfaceSelectionDialog_interfaceadded_info;
	public static String SuperInterfaceSelectionDialog_interfacealreadyadded_info;
	
	public static String NewClassCreationWizard_title;
	public static String NewClassWizardPage_title;
	public static String NewClassWizardPage_description;
	public static String NewClassWizardPage_methods_label;
	public static String NewClassWizardPage_methods_main;
	public static String NewClassWizardPage_methods_constructors;
	public static String NewClassWizardPage_methods_inherited;
	
	public static String NewInterfaceCreationWizard_title;
	public static String NewInterfaceWizardPage_title;
	public static String NewInterfaceWizardPage_description;
	
	public static String NewEnumCreationWizard_title;
	public static String NewEnumWizardPage_title;
	public static String NewEnumWizardPage_description;
	
	public static String NewAnnotationCreationWizard_title;
	public static String NewAnnotationWizardPage_title;
	public static String NewAnnotationWizardPage_description;
	
	public static String JavaCapabilityConfigurationPage_title;
	public static String JavaCapabilityConfigurationPage_description;
	public static String JavaCapabilityConfigurationPage_op_desc_java;
	
	public static String JavaProjectWizard_title;
	public static String JavaProjectWizard_op_error_title;
	public static String JavaProjectWizard_op_error_create_message;
	
	public static String NewJavaProjectWizardPage_title;
	public static String NewJavaProjectWizardPage_description;
	public static String NewJavaProjectWizardPage_op_desc;
	
	public static String NewSourceFolderCreationWizard_title;
	public static String NewSourceFolderCreationWizard_edit_title;
	public static String NewSourceFolderCreationWizard_link_title;
	public static String NewSourceFolderWizardPage_title;
	public static String NewSourceFolderWizardPage_description;
	public static String NewSourceFolderWizardPage_root_label;
	public static String NewSourceFolderWizardPage_root_button;
	public static String NewSourceFolderWizardPage_project_label;
	public static String NewSourceFolderWizardPage_project_button;
	public static String NewSourceFolderWizardPage_operation;
	public static String NewSourceFolderWizardPage_exclude_label;
	public static String NewSourceFolderWizardPage_ChooseExistingRootDialog_title;
	public static String NewSourceFolderWizardPage_ChooseExistingRootDialog_description;
	public static String NewSourceFolderWizardPage_ChooseProjectDialog_title;
	public static String NewSourceFolderWizardPage_ChooseProjectDialog_description;
	public static String NewSourceFolderWizardPage_error_EnterRootName;
	public static String NewSourceFolderWizardPage_error_InvalidRootName;
	public static String NewSourceFolderWizardPage_error_NotAFolder;
	public static String NewSourceFolderWizardPage_error_AlreadyExisting;
	public static String NewSourceFolderWizardPage_error_AlreadyExistingDifferentCase;
	public static String NewSourceFolderWizardPage_error_EnterProjectName;
	public static String NewSourceFolderWizardPage_error_InvalidProjectPath;
	public static String NewSourceFolderWizardPage_error_NotAJavaProject;
	public static String NewSourceFolderWizardPage_error_ProjectNotExists;
	public static String NewSourceFolderWizardPage_warning_ReplaceSFandOL;
	public static String NewSourceFolderWizardPage_warning_ReplaceOL;
	public static String NewSourceFolderWizardPage_warning_ReplaceSF;
	public static String NewSourceFolderWizardPage_warning_AddedExclusions;
	public static String NewSourceFolderWizardPage_ReplaceExistingSourceFolder_label;
	public static String NewSourceFolderWizardPage_edit_description;
	
	public static String BuildPathsBlock_tab_source;
	public static String BuildPathsBlock_tab_projects;
	public static String BuildPathsBlock_tab_libraries;
	public static String BuildPathsBlock_tab_order;
	public static String BuildPathsBlock_classpath_label;
	public static String BuildPathsBlock_classpath_up_button;
	public static String BuildPathsBlock_classpath_down_button;
	public static String BuildPathsBlock_classpath_top_button;
	public static String BuildPathsBlock_classpath_bottom_button;
	public static String BuildPathsBlock_classpath_checkall_button;
	public static String BuildPathsBlock_classpath_uncheckall_button;
	public static String BuildPathsBlock_buildpath_label;
	public static String BuildPathsBlock_buildpath_button;
	public static String BuildPathsBlock_error_InvalidBuildPath;
	public static String BuildPathsBlock_error_EnterBuildPath;
	public static String BuildPathsBlock_warning_EntryMissing;
	public static String BuildPathsBlock_warning_EntriesMissing;
	public static String BuildPathsBlock_operationdesc_project;
	public static String BuildPathsBlock_operationdesc_java;
	public static String BuildPathsBlock_ChooseOutputFolderDialog_title;
	public static String BuildPathsBlock_ChooseOutputFolderDialog_description;
	public static String BuildPathsBlock_RemoveBinariesDialog_title;
	public static String BuildPathsBlock_RemoveBinariesDialog_description;
	
	public static String CPListLabelProvider_new;
	public static String CPListLabelProvider_classcontainer;
	public static String CPListLabelProvider_twopart;
	public static String CPListLabelProvider_willbecreated;
	public static String CPListLabelProvider_unbound_library;
	public static String CPListLabelProvider_systemlibrary;
	public static String CPListLabelProvider_native_library_path;
	
	public static String SourceContainerWorkbookPage_folders_label;
	public static String SourceContainerWorkbookPage_folders_remove_button;
	public static String SourceContainerWorkbookPage_folders_add_button;
	public static String SourceContainerWorkbookPage_folders_edit_button;
	public static String SourceContainerWorkbookPage_folders_check;
	public static String SourceContainerWorkbookPage_ExistingSourceFolderDialog_new_title;
	public static String SourceContainerWorkbookPage_ExistingSourceFolderDialog_new_description;
	public static String SourceContainerWorkbookPage_NewSourceFolderDialog_new_title;
	public static String SourceContainerWorkbookPage_NewSourceFolderDialog_edit_title;
	public static String SourceContainerWorkbookPage_NewSourceFolderDialog_description;
	public static String SourceContainerWorkbookPage_ChangeOutputLocationDialog_title;
	public static String SourceContainerWorkbookPage_ChangeOutputLocationDialog_project_and_output_message;
	public static String SourceContainerWorkbookPage_ChangeOutputLocationDialog_project_message;
	public static String SourceContainerWorkbookPage_ExistingSourceFolderDialog_edit_title;
	public static String SourceContainerWorkbookPage_ExistingSourceFolderDialog_edit_description;
	public static String SourceContainerWorkbookPage_exclusion_added_title;
	public static String SourceContainerWorkbookPage_exclusion_added_message;
	public static String SourceContainerWorkbookPage_folders_link_source_button;
	public static String SourceContainerWorkbookPage_error_while_linking;
	
	public static String ProjectsWorkbookPage_projects_label;
	public static String ProjectsWorkbookPage_projects_add_button;
	public static String ProjectsWorkbookPage_projects_edit_button;
	public static String ProjectsWorkbookPage_projects_remove_button;
	public static String ProjectsWorkbookPage_chooseProjects_message;
	public static String ProjectsWorkbookPage_chooseProjects_title;
	
	public static String LibrariesWorkbookPage_libraries_label;
	public static String LibrariesWorkbookPage_libraries_remove_button;
	public static String LibrariesWorkbookPage_libraries_addjar_button;
	public static String LibrariesWorkbookPage_libraries_addextjar_button;
	public static String LibrariesWorkbookPage_libraries_addvariable_button;
	public static String LibrariesWorkbookPage_libraries_addlibrary_button;
	public static String LibrariesWorkbookPage_libraries_addclassfolder_button;
	public static String LibrariesWorkbookPage_libraries_replace_button;
	public static String LibrariesWorkbookPage_configurecontainer_error_title;
	public static String LibrariesWorkbookPage_configurecontainer_error_message;
	public static String LibrariesWorkbookPage_libraries_edit_button;
	public static String LibrariesWorkbookPage_NewClassFolderDialog_new_title;
	public static String LibrariesWorkbookPage_NewClassFolderDialog_edit_title;
	public static String LibrariesWorkbookPage_NewClassFolderDialog_description;
	public static String LibrariesWorkbookPage_JavadocPropertyDialog_title;
	public static String LibrariesWorkbookPage_exclusion_added_title;
	public static String LibrariesWorkbookPage_exclusion_added_message;
	
	public static String BuildPathDialogAccess_ExistingSourceFolderDialog_new_title;
	public static String BuildPathDialogAccess_ExistingSourceFolderDialog_new_description;
	public static String BuildPathDialogAccess_ExistingClassFolderDialog_new_title;
	public static String BuildPathDialogAccess_ExistingClassFolderDialog_new_description;
	public static String BuildPathDialogAccess_JARArchiveDialog_new_title;
	public static String BuildPathDialogAccess_JARArchiveDialog_new_description;
	public static String BuildPathDialogAccess_JARArchiveDialog_edit_title;
	public static String BuildPathDialogAccess_JARArchiveDialog_edit_description;
	public static String BuildPathDialogAccess_ExtJARArchiveDialog_new_title;
	public static String BuildPathDialogAccess_ExtJARArchiveDialog_edit_title;
	
	public static String NewContainerDialog_error_invalidpath;
	public static String NewContainerDialog_error_enterpath;
	public static String NewContainerDialog_error_pathexists;
	public static String NewSourceFolderDialog_error_invalidpath;
	public static String NewSourceFolderDialog_error_enterpath;
	public static String NewSourceFolderDialog_error_pathexists;
	
	public static String SourceAttachmentBlock_message;
	public static String SourceAttachmentBlock_filename_description;
	public static String SourceAttachmentBlock_filename_label;
	public static String SourceAttachmentBlock_filename_externalfile_button;
	public static String SourceAttachmentBlock_filename_externalfolder_button;
	public static String SourceAttachmentBlock_filename_internal_button;
	public static String SourceAttachmentBlock_filename_varlabel;
	public static String SourceAttachmentBlock_filename_variable_button;
	public static String SourceAttachmentBlock_filename_external_varbutton;
	public static String SourceAttachmentBlock_filename_error_notvalid;
	public static String SourceAttachmentBlock_filename_error_notabsolute;
	public static String SourceAttachmentBlock_filename_error_filenotexists;
	public static String SourceAttachmentBlock_filename_error_varnotexists;
	public static String SourceAttachmentBlock_filename_error_deviceinpath;
	public static String SourceAttachmentBlock_filename_warning_varempty;
	public static String SourceAttachmentBlock_intjardialog_title;
	public static String SourceAttachmentBlock_intjardialog_message;
	public static String SourceAttachmentBlock_extvardialog_title;
	public static String SourceAttachmentBlock_extvardialog_description;
	public static String SourceAttachmentBlock_extjardialog_text;
	public static String SourceAttachmentBlock_extfolderdialog_text;
	
	public static String BuildPathSupport_putoncpdialog_title;
	public static String BuildPathSupport_putoncpdialog_message;
	
	public static String SourceAttachmentDialog_title;
	public static String EditVariableEntryDialog_title;
	public static String EditVariableEntryDialog_filename_varlabel;
	public static String EditVariableEntryDialog_filename_variable_button;
	public static String EditVariableEntryDialog_filename_external_varbutton;
	public static String EditVariableEntryDialog_extvardialog_title;
	public static String EditVariableEntryDialog_extvardialog_description;
	public static String EditVariableEntryDialog_filename_error_notvalid;
	public static String EditVariableEntryDialog_filename_error_filenotexists;
	public static String EditVariableEntryDialog_filename_error_varnotexists;
	public static String EditVariableEntryDialog_filename_error_deviceinpath;
	public static String EditVariableEntryDialog_filename_warning_varempty;
	public static String EditVariableEntryDialog_filename_error_alreadyexists;
	
	public static String VariableBlock_vars_label;
	public static String VariableBlock_vars_add_button;
	public static String VariableBlock_vars_edit_button;
	public static String VariableBlock_vars_remove_button;
	public static String VariableBlock_operation_desc;
	public static String VariableBlock_job_description;
	public static String VariableBlock_needsbuild_title;
	public static String VariableBlock_needsbuild_message;
	public static String VariableBlock_variableSettingError_titel;
	public static String VariableBlock_variableSettingError_message;
	public static String VariablePathDialogField_variabledialog_title;
	
	public static String CPVariableElementLabelProvider_empty;
	
	public static String VariableCreationDialog_titlenew;
	public static String VariableCreationDialog_titleedit;
	public static String VariableCreationDialog_name_label;
	public static String VariableCreationDialog_path_label;
	public static String VariableCreationDialog_path_file_button;
	public static String VariableCreationDialog_path_dir_button;
	public static String VariableCreationDialog_error_entername;
	public static String VariableCreationDialog_error_whitespace;
	public static String VariableCreationDialog_error_invalidname;
	public static String VariableCreationDialog_error_nameexists;
	public static String VariableCreationDialog_error_invalidpath;
	public static String VariableCreationDialog_warning_pathnotexists;
	public static String VariableCreationDialog_extjardialog_text;
	public static String VariableCreationDialog_extdirdialog_text;
	public static String VariableCreationDialog_extdirdialog_message;
	
	public static String NewVariableEntryDialog_title;
	public static String NewVariableEntryDialog_vars_extend;
	public static String NewVariableEntryDialog_configbutton_label;
	public static String NewVariableEntryDialog_vars_label;
	public static String NewVariableEntryDialog_ExtensionDialog_title;
	public static String NewVariableEntryDialog_ExtensionDialog_description;
	public static String NewVariableEntryDialog_info_isfolder;
	public static String NewVariableEntryDialog_info_notexists;
	public static String NewVariableEntryDialog_info_noselection;
	public static String NewVariableEntryDialog_info_selected;
	
	public static String OutputLocationDialog_title;
	public static String OutputLocationDialog_usedefault_label;
	public static String OutputLocationDialog_usespecific_label;
	public static String OutputLocationDialog_location_button;
	public static String OutputLocationDialog_error_existingisfile;
	public static String OutputLocationDialog_error_invalidpath;
	public static String OutputLocationDialog_ChooseOutputFolder_title;
	public static String OutputLocationDialog_ChooseOutputFolder_description;
	
	public static String ExclusionInclusionDialog_title;
	public static String ExclusionInclusionDialog_description;
	public static String ExclusionInclusionDialog_description2;
	public static String ExclusionInclusionDialog_exclusion_pattern_label;
	public static String ExclusionInclusionDialog_inclusion_pattern_label;
	public static String ExclusionInclusionDialog_inclusion_pattern_add;
	public static String ExclusionInclusionDialog_inclusion_pattern_add_multiple;
	public static String ExclusionInclusionDialog_inclusion_pattern_remove;
	public static String ExclusionInclusionDialog_inclusion_pattern_edit;
	public static String ExclusionInclusionDialog_exclusion_pattern_add;
	public static String ExclusionInclusionDialog_exclusion_pattern_add_multiple;
	public static String ExclusionInclusionDialog_exclusion_pattern_remove;
	public static String ExclusionInclusionDialog_exclusion_pattern_edit;
	public static String ExclusionInclusionDialog_ChooseExclusionPattern_title;
	public static String ExclusionInclusionDialog_ChooseExclusionPattern_description;
	public static String ExclusionInclusionDialog_ChooseInclusionPattern_title;
	public static String ExclusionInclusionDialog_ChooseInclusionPattern_description;
	public static String ExclusionInclusionDialog_Info_SrcAndOutput;
	public static String ExclusionInclusionDialog_Info_Src;
	public static String ExclusionInclusionDialog_Info_Output;
	public static String ExclusionInclusionEntryDialog_exclude_add_title;
	public static String ExclusionInclusionEntryDialog_exclude_edit_title;
	public static String ExclusionInclusionEntryDialog_exclude_description;
	public static String ExclusionInclusionEntryDialog_exclude_pattern_label;
	public static String ExclusionInclusionEntryDialog_include_add_title;
	public static String ExclusionInclusionEntryDialog_include_edit_title;
	public static String ExclusionInclusionEntryDialog_include_description;
	public static String ExclusionInclusionEntryDialog_include_pattern_label;
	public static String ExclusionInclusionEntryDialog_pattern_button;
	public static String ExclusionInclusionEntryDialog_error_empty;
	public static String ExclusionInclusionEntryDialog_error_notrelative;
	public static String ExclusionInclusionEntryDialog_error_exists;
	public static String ExclusionInclusionEntryDialog_ChooseExclusionPattern_title;
	public static String ExclusionInclusionEntryDialog_ChooseExclusionPattern_description;
	public static String ExclusionInclusionEntryDialog_ChooseInclusionPattern_title;
	public static String ExclusionInclusionEntryDialog_ChooseInclusionPattern_description;
	
	public static String AccessRulesDialog_title;
	public static String AccessRulesDialog_container_description;
	public static String AccessRulesDialog_project_description;
	public static String AccessRulesDialog_description;
	public static String AccessRulesDialog_rules_label;
	public static String AccessRulesDialog_rules_add;
	public static String AccessRulesDialog_rules_up;
	public static String AccessRulesDialog_rules_remove;
	public static String AccessRulesDialog_combine_label;
	public static String AccessRulesDialog_rules_edit;
	public static String AccessRulesDialog_rules_down;
	public static String AccessRulesLabelProvider_kind_accessible;
	public static String AccessRulesLabelProvider_kind_discouraged;
	public static String AccessRulesLabelProvider_kind_non_accessible;
	
	public static String TypeRestrictionEntryDialog_add_title;
	public static String TypeRestrictionEntryDialog_edit_title;
	public static String TypeRestrictionEntryDialog_pattern_label;
	public static String TypeRestrictionEntryDialog_description;
	public static String TypeRestrictionEntryDialog_description2;
	public static String TypeRestrictionEntryDialog_error_empty;
	public static String TypeRestrictionEntryDialog_error_notrelative;
	public static String TypeRestrictionEntryDialog_kind_accessible;
	public static String TypeRestrictionEntryDialog_kind_label;
	public static String TypeRestrictionEntryDialog_kind_discourraged;
	public static String TypeRestrictionEntryDialog_kind_non_accessible;
	
	public static String ClasspathContainerDefaultPage_title;
	public static String ClasspathContainerDefaultPage_description;
	public static String ClasspathContainerDefaultPage_path_label;
	public static String ClasspathContainerDefaultPage_path_error_enterpath;
	public static String ClasspathContainerDefaultPage_path_error_invalidpath;
	public static String ClasspathContainerDefaultPage_path_error_needssegment;
	public static String ClasspathContainerDefaultPage_path_error_alreadyexists;
	public static String ClasspathContainerSelectionPage_title;
	public static String ClasspathContainerSelectionPage_description;
	public static String ClasspathContainerWizard_pagecreationerror_title;
	public static String ClasspathContainerWizard_pagecreationerror_message;
	public static String ClasspathContainerWizard_new_title;
	public static String ClasspathContainerWizard_edit_title;
	
	public static String FolderSelectionDialog_button;
	public static String MultipleFolderSelectionDialog_button;
	
	public static String CPListLabelProvider_none;
	public static String CPListLabelProvider_all;
	public static String CPListLabelProvider_source_attachment_label;
	public static String CPListLabelProvider_javadoc_location_label;
	public static String CPListLabelProvider_output_folder_label;
	public static String CPListLabelProvider_default_output_folder_label;
	public static String CPListLabelProvider_exclusion_filter_label;
	public static String CPListLabelProvider_exclusion_filter_separator;
	public static String CPListLabelProvider_inclusion_filter_label;
	public static String CPListLabelProvider_inclusion_filter_separator;
	public static String CPListLabelProvider_unknown_element_label;
	public static String CPListLabelProvider_access_rules_enabled;
	public static String CPListLabelProvider_project_access_rules_combined;
	public static String CPListLabelProvider_project_access_rules_no_rules;
	public static String CPListLabelProvider_project_access_rules_not_combined;
	public static String CPListLabelProvider_access_rules_disabled;
	
	public static String NewSourceFolderDialog_useproject_button;
	public static String NewSourceFolderDialog_usefolder_button;
	public static String NewSourceFolderDialog_sourcefolder_label;
	
	public static String JavaProjectWizardFirstPage_NameGroup_label_text;
	public static String JavaProjectWizardFirstPage_LocationGroup_title;
	public static String JavaProjectWizardFirstPage_LocationGroup_external_desc;
	public static String JavaProjectWizardFirstPage_LocationGroup_workspace_desc;
	public static String JavaProjectWizardFirstPage_LocationGroup_locationLabel_desc;
	public static String JavaProjectWizardFirstPage_LocationGroup_browseButton_desc;
	public static String JavaProjectWizardFirstPage_LayoutGroup_title;
	public static String JavaProjectWizardFirstPage_LayoutGroup_option_separateFolders;
	public static String JavaProjectWizardFirstPage_LayoutGroup_option_oneFolder;
	public static String JavaProjectWizardFirstPage_LayoutGroup_configure;
	public static String JavaProjectWizardFirstPage_DetectGroup_message;
	public static String JavaProjectWizardFirstPage_Message_enterProjectName;
	public static String JavaProjectWizardFirstPage_Message_projectAlreadyExists;
	public static String JavaProjectWizardFirstPage_Message_enterLocation;
	public static String JavaProjectWizardFirstPage_Message_invalidDirectory;
	public static String JavaProjectWizardFirstPage_Message_cannotCreateAtExternalLocation;
	public static String JavaProjectWizardFirstPage_page_pageName;
	public static String JavaProjectWizardFirstPage_page_title;
	public static String JavaProjectWizardFirstPage_page_description;
	
	public static String HintTextGroup_Exception_Title;
	public static String HintTextGroup_Exception_Title_refresh;
	public static String HintTextGroup_Exception_Title_output;
	public static String HintTextGroup_NoAction;
	
	public static String NewSourceContainerWorkbookPage_Exception_Title;
	public static String NewSourceContainerWorkbookPage_Exception_refresh;
	public static String NewSourceContainerWorkbookPage_HintTextGroup_title;
	public static String NewSourceContainerWorkbookPage_ToolBar_CreateFolder_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_ConfigureBP_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_ConfigureBP_label;
	public static String NewSourceContainerWorkbookPage_ToolBar_Edit_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_Edit_label;
	public static String NewSourceContainerWorkbookPage_ToolBar_EditOutput_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_EditOutput_label;
	public static String NewSourceContainerWorkbookPage_ToolBar_AddSelSFToCP_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_AddSelSFToCP_label;
	public static String NewSourceContainerWorkbookPage_ToolBar_AddSelLibToCP_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_AddSelLibToCP_label;
	
	public static String NewSourceContainerWorkbookPage_ToolBar_AddJarCP_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_AddJarCP_label;
	public static String NewSourceContainerWorkbookPage_ToolBar_AddLibCP_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_AddLibCP_label;
	public static String NewSourceContainerWorkbookPage_ToolBar_RemoveFromCP_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_RemoveFromCP_label;
	public static String NewSourceContainerWorkbookPage_ToolBar_Include_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_Exclude_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_Exclude_label;
	public static String NewSourceContainerWorkbookPage_ToolBar_Uninclude_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_Unexclude_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_Unexclude_label;
	public static String NewSourceContainerWorkbookPage_ToolBar_Reset_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_ClearAll_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_ClearAll_label;
	public static String NewSourceContainerWorkbookPage_ToolBar_CreateOutput_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_Link_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_Link_label;
	public static String NewSourceContainerWorkbookPage_ToolBar_Help_tooltip;
	public static String NewSourceContainerWorkbookPage_ToolBar_Help_label;
	public static String NewSourceContainerWorkbookPage_ToolBar_Help_link;
	public static String NewSourceContainerWorkbookPage_ToolBar_CreateSrcFolder_label;
	public static String NewSourceContainerWorkbookPage_ToolBar_CreateSrcFolder_tooltip;
	
	public static String NewFolderDialog_TypeGroup_title;
	public static String NewFolderDialog_folderNameGroup_label;
	public static String NewFolderDialog_folderTypeGroup_source_desc;
	public static String NewFolderDialog_folderTypeGroup_normal_desc;
	public static String NewFolderDialog_dependenciesGroup_none_desc;
	public static String NewFolderDialog_dependenciesGroup_copy_desc;
	public static String NewFolderDialog_dependenciesGroup_link_desc;
	public static String NewFolderDialog_dependenciesGroup_link_descDisabled;
	public static String NewFolderDialog_dependenciesGroup_locationLabel_desc;
	public static String NewFolderDialog_dependenciesGroup_browseButton_desc;
	public static String NewFolderDialog_dependenciesGroup_variables_desc;
	public static String NewFolderDialog_DependencyGroup_title;
	public static String NewFolderDialog_links_parentNotProject;
	public static String NewFolderDialog_linkTargetNonExistent;
	public static String NewFolderDialog_linkTargetNotFolder;
	public static String NewFolderDialog_folderNameEmpty;
	public static String NewFolderDialog_folderNameEmpty_alreadyExists;
	public static String NewFolderDialog_title;
	public static String NewFolderDialog_errorTitle;
	public static String NewFolderDialog_internalError;
	public static String NewFolderDialog_progress;
	public static String NewFolderDialog_notExists;
	public static String NewFolderDialog_createIn;
	
	public static String LinkFolderDialog_title;
	public static String LinkFolderDialog_createIn;
	public static String LinkFolderDialog_folderNameGroup_label;
	public static String LinkFolderDialog_dependenciesGroup_locationLabel_desc;
	public static String LinkFolderDialog_dependenciesGroup_browseButton_desc;
	public static String LinkFolderDialog_dependenciesGroup_variables_desc;
	
	public static String PackageExplorerActionGroup_NoAction_File;
	public static String PackageExplorerActionGroup_NoAction_DefaultPackage;
	public static String PackageExplorerActionGroup_NoAction_NullSelection;
	public static String PackageExplorerActionGroup_NoAction_MultiSelection;
	public static String PackageExplorerActionGroup_NoAction_ArchiveResource;
	public static String PackageExplorerActionGroup_NoAction_NoReason;
	public static String PackageExplorerActionGroup_FormText_create;
	public static String PackageExplorerActionGroup_FormText_createLinkedFolder;
	public static String PackageExplorerActionGroup_FormText_FolderToBuildpath;
	public static String PackageExplorerActionGroup_FormText_ArchiveToBuildpath;
	public static String PackageExplorerActionGroup_FormText_PackageToBuildpath;
	public static String PackageExplorerActionGroup_FormText_ProjectToBuildpath;
	public static String PackageExplorerActionGroup_FormText_fromBuildpath;
	public static String PackageExplorerActionGroup_FormText_ProjectFromBuildpath;
	public static String PackageExplorerActionGroup_FormText_ExcludePackage;
	public static String PackageExplorerActionGroup_FormText_ExcludeFile;
	public static String PackageExplorerActionGroup_FormText_Include;
	public static String PackageExplorerActionGroup_FormText_Edit;
	public static String PackageExplorerActionGroup_FormText_UnexcludeFolder;
	public static String PackageExplorerActionGroup_FormText_UnincludeFolder;
	public static String PackageExplorerActionGroup_FormText_UnincludeFile;
	public static String PackageExplorerActionGroup_FormText_ResetFilters;
	public static String PackageExplorerActionGroup_FormText_UnexcludeFile;
	public static String PackageExplorerActionGroup_FormText_EditOutputFolder;
	public static String PackageExplorerActionGroup_FormText_SetOutputToDefault;
	public static String PackageExplorerActionGroup_FormText_Default_Uninclude;
	public static String PackageExplorerActionGroup_FormText_Default_Unexclude;
	public static String PackageExplorerActionGroup_FormText_Default_ResetAllOutputFolders;
	public static String PackageExplorerActionGroup_FormText_Default_FromBuildpath;
	public static String PackageExplorerActionGroup_FormText_Default_Include;
	public static String PackageExplorerActionGroup_FormText_Default_Exclude;
	public static String PackageExplorerActionGroup_FormText_Default_CreateOutput;
	public static String PackageExplorerActionGroup_FormText_Default_toBuildpath;
	public static String PackageExplorerActionGroup_FormText_Default_toBuildpath_archives;
	public static String PackageExplorerActionGroup_FormText_Default_toBuildpath_library;
	public static String PackageExplorerActionGroup_FormText_Default_Reset;
	public static String PackageExplorerActionGroup_FormText_Default_ResetAll;
	public static String PackageExplorerActionGroup_FormText_createNewSourceFolder;
	
	public static String DialogPackageExplorer_LabelProvider_Excluded;
	public static String DialogPackageExplorer_LabelProvider_SingleExcluded;
	public static String DialogPackageExplorer_LabelProvider_MultiExcluded;
	
	public static String ClasspathModifier_Monitor_AddToBuildpath;
	public static String ClasspathModifier_Monitor_RemoveFromBuildpath;
	public static String ClasspathModifier_Monitor_ResetFilters;
	public static String ClasspathModifier_Monitor_Including;
	public static String ClasspathModifier_Monitor_RemoveInclusion;
	public static String ClasspathModifier_Monitor_Excluding;
	public static String ClasspathModifier_Monitor_RemoveExclusion;
	public static String ClasspathModifier_Monitor_ContainsPath;
	public static String ClasspathModifier_Monitor_ExamineInputFilters;
	public static String ClasspathModifier_Monitor_EditInclusionExclusionFilters;
	public static String ClasspathModifier_Monitor_RemovePath;
	public static String ClasspathModifier_Monitor_CheckOutputFolders;
	public static String ClasspathModifier_Monitor_Resetting;
	public static String ClasspathModifier_Monitor_SetNewEntry;
	public static String ClasspathModifier_Monitor_ComparePaths;
	public static String ClasspathModifier_Monitor_ResetOutputFolder;
	public static String ClasspathModifier_ChangeOutputLocationDialog_title;
	public static String ClasspathModifier_ChangeOutputLocationDialog_project_message;
	public static String ClasspathModifier_ChangeOutputLocationDialog_project_outputLocation;
	public static String ClasspathModifier_Error_NoNatures;

	public static String ClassPathDetector_operation_description;
	public static String ClassPathDetector_error_closing_file;
	
	public static String JavaProjectWizardSecondPage_error_title;
	public static String JavaProjectWizardSecondPage_error_message;
	public static String JavaProjectWizardSecondPage_problem_backup;
	public static String JavaProjectWizardSecondPage_operation_initialize;
	public static String JavaProjectWizardSecondPage_operation_create;
	public static String JavaProjectWizardSecondPage_operation_remove;
	public static String JavaProjectWizardSecondPage_error_remove_title;
	public static String JavaProjectWizardSecondPage_error_remove_message;
	public static String JavaProjectWizardSecondPage_problem_restore_project;
	public static String JavaProjectWizardSecondPage_problem_restore_classpath;
	public static String JavaProjectWizardFirstPage_directory_message;
	
	public static String UserLibraryWizardPage_title;
	public static String UserLibraryWizardPage_list_config_button;
	public static String UserLibraryWizardPage_list_label;
	public static String UserLibraryWizardPage_description_new;
	public static String UserLibraryWizardPage_description_edit;
	public static String UserLibraryWizardPage_error_selectentry;
	public static String UserLibraryWizardPage_error_selectonlyone;
	public static String UserLibraryWizardPage_error_alreadyoncp;
	public static String UserLibraryMarkerResolutionGenerator_changetouserlib_label;
	public static String UserLibraryMarkerResolutionGenerator_createuserlib_label;
	public static String UserLibraryMarkerResolutionGenerator_changetoother;
	public static String UserLibraryMarkerResolutionGenerator_error_creationfailed_message;
	public static String UserLibraryMarkerResolutionGenerator_error_title;
	public static String UserLibraryMarkerResolutionGenerator_error_applyingfailed_message;
	
	public static String ChangeComplianceDialog_title;
	public static String ChangeComplianceDialog_message;
	public static String ChangeComplianceDialog_project_selection;
	public static String ChangeComplianceDialog_workspace_selection;
	public static String GenerateBuildPathActionGroup_no_action_available;

	public static String GroovyProjectWizard_BuildSettings;
    public static String GroovyProjectWizard_BuildSettingsDesc;
    public static String GroovyProjectWizard_CreateGroovyProject;
    public static String GroovyProjectWizard_CreateGroovyProjectDesc;
    public static String GroovyProjectWizard_NewGroovyProject;
    public static String GroovyProjectWizard_OpErrorCreateMessage;
    public static String GroovyProjectWizard_OpErrorTitle;
    public static String NativeLibrariesDialog_extfiledialog_text;
	public static String NativeLibrariesDialog_intfiledialog_title;
	public static String NativeLibrariesDialog_intfiledialog_message;
	public static String NativeLibrariesDialog_location_label;
	public static String NativeLibrariesDialog_workspace_browse;
	public static String NativeLibrariesDialog_external_browse;
	public static String NativeLibrariesDialog_description;
	public static String NativeLibrariesDialog_title;
	public static String NativeLibrariesDialog_error_external_not_existing;
	public static String NativeLibrariesDialog_error_internal_not_existing;
	
	public static String NewContainerWizardPage_warning_inside_classfolder;
	
	public static String CPListLabelProvider_non_modifiable_attribute;
	public static String CPListLabelProvider_access_rules_label;
	public static String CPListLabelProvider_container_access_rules;
	public static String CPListLabelProvider_container_no_access_rules;
	
	public static String NativeLibrariesDialog_external_message;
	public static String SourceAttachmentBlock_extfolderdialog_message;
	public static String AccessRulesDialog_severity_info_with_link;
	public static String AccessRulesDialog_severity_info_no_link;
	public static String AccessRulesDialog_severity_error;
	public static String AccessRulesDialog_severity_warning;
	public static String AccessRulesDialog_severity_ignore;
	public static String AccessRulesDialog_switch_dialog_title;
	public static String AccessRulesDialog_switch_dialog_message;
	public static String JavaProjectWizardFirstPage_LayoutGroup_link_description;
	public static String JavaProjectWizardFirstPage_JREGroup_title;
	public static String JavaProjectWizardFirstPage_JREGroup_default_compliance;
	public static String JavaProjectWizardFirstPage_JREGroup_link_description;
	public static String JavaProjectWizardFirstPage_JREGroup_specific_compliance;
	public static String JavaProjectWizardFirstPage_JREGroup_compliance_13;
	public static String JavaProjectWizardFirstPage_JREGroup_compliance_14;
	public static String JavaProjectWizardFirstPage_JREGroup_compliance_50;
	public static String ClasspathModifierQueries_confirm_remove_linked_folder_label;
	public static String ClasspathModifierQueries_confirm_remove_linked_folder_message;
	public static String ClasspathModifierQueries_delete_linked_folder;
	public static String ClasspathModifierQueries_do_not_delete_linked_folder;
	public static String EditVariableEntryDialog_filename_empty;
	public static String JavaProjectWizardFirstPage_DetectGroup_jre_message;

	static {
		NLS.initializeMessages(BUNDLE_NAME, NewWizardMessages.class);
	}
}

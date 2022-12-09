package com.test.mongotest.model.asset;

import lombok.AllArgsConstructor;

/**
 * Access Roles supported
 */
@AllArgsConstructor
public enum AccessRole {
    NONE,
    VIEWER,
    EDITOR,
    FULL_ACCESS,
    VIEW_EXPORT_PDF,
    VIEW_EXPORT_SUMMARY,
    VIEWER_EXPORT_UNDERLYING_DATA,
    VIEW_ONLY_EDITOR
}



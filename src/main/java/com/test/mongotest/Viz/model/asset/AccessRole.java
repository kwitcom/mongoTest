package com.test.mongotest.Viz.model.asset;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AccessRole {
    NONE,
    VIEWER,
    VIEW_EXPORT_PDF,
    VIEW_EXPORT_SUMMARY,
    VIEWER_EXPORT_UNDERLYING_DATA,
    VIEW_ONLY_EDITOR,
    EDITOR,
    FULL_ACCESS
}
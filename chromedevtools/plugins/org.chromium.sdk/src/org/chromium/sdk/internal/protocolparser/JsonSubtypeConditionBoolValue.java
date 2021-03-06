// Copyright (c) 2009 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.sdk.internal.protocolparser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies a condition for a field-reading method. It is one from group of annotations that
 * mark key fields for choosing particular subtype. They set conditions on JSON fields in a subtype
 * interface that drive subtype auto-selection at parsing time.
 * <p>
 * Specifies condition on a boolean value (for boolean-valued fields).
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonSubtypeConditionBoolValue {
  /**
   * A value of boolean field that satisfies condition.
   */
  boolean value();
}

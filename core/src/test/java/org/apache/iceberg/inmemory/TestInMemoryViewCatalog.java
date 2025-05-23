/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.iceberg.inmemory;

import org.apache.iceberg.CatalogProperties;
import org.apache.iceberg.catalog.Catalog;
import org.apache.iceberg.relocated.com.google.common.collect.ImmutableMap;
import org.apache.iceberg.view.ViewCatalogTests;
import org.junit.jupiter.api.BeforeEach;

public class TestInMemoryViewCatalog extends ViewCatalogTests<InMemoryCatalog> {
  private InMemoryCatalog catalog;

  @BeforeEach
  public void before() {
    this.catalog = new InMemoryCatalog();
    this.catalog.initialize(
        "in-memory-catalog",
        ImmutableMap.<String, String>builder()
            .put(CatalogProperties.VIEW_DEFAULT_PREFIX + "key1", "catalog-default-key1")
            .put(CatalogProperties.VIEW_DEFAULT_PREFIX + "key2", "catalog-default-key2")
            .put(CatalogProperties.VIEW_DEFAULT_PREFIX + "key3", "catalog-default-key3")
            .put(CatalogProperties.VIEW_OVERRIDE_PREFIX + "key3", "catalog-override-key3")
            .put(CatalogProperties.VIEW_OVERRIDE_PREFIX + "key4", "catalog-override-key4")
            .build());
  }

  @Override
  protected InMemoryCatalog catalog() {
    return catalog;
  }

  @Override
  protected Catalog tableCatalog() {
    return catalog;
  }

  @Override
  protected boolean requiresNamespaceCreate() {
    return true;
  }

  @Override
  protected boolean supportsEmptyNamespace() {
    return true;
  }
}

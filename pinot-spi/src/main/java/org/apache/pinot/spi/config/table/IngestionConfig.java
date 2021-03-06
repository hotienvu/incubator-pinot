/**
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
package org.apache.pinot.spi.config.table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.pinot.spi.config.BaseJsonConfig;
import org.apache.pinot.spi.config.table.ingestion.FilterConfig;
import org.apache.pinot.spi.config.table.ingestion.TransformConfig;


/**
 * Class representing table ingestion configuration. For example, configs needed for
 * decoding, data source configs, ingestion transformations (flattening, filtering, transformations etc.)
 * TODO: Move fields from table config which are ingestion related (e.g. streamConfigs, segment push type, append freq etc)
 */
public class IngestionConfig extends BaseJsonConfig {

  @JsonPropertyDescription("Config related to filtering records during ingestion")
  private final FilterConfig _filterConfig;

  @JsonPropertyDescription("Configs related to record transformation functions applied during ingestion")
  private final List<TransformConfig> _transformConfigs;

  @JsonCreator
  public IngestionConfig(@JsonProperty("filterConfig") @Nullable FilterConfig filterConfig,
      @JsonProperty("transformConfigs") @Nullable List<TransformConfig> transformConfigs) {
    _filterConfig = filterConfig;
    _transformConfigs = transformConfigs;
  }

  @Nullable
  public FilterConfig getFilterConfig() {
    return _filterConfig;
  }

  @Nullable
  public List<TransformConfig> getTransformConfigs() {
    return _transformConfigs;
  }
}

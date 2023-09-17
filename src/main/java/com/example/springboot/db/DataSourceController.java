package com.example.springboot.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/datasource")
public class DataSourceController {
  private final DataSourceConfiguration dataSourceConfiguration;

  @Autowired
  public DataSourceController(DataSourceConfiguration dataSourceConfiguration) {
    this.dataSourceConfiguration = dataSourceConfiguration;
  }

  @RequestMapping
  public DataSourceConfiguration getDataSourceConfiguration() {
    return this.dataSourceConfiguration;
  }
}

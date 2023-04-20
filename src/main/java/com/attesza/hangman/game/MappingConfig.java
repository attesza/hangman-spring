package com.gallows.demo;

import org.mapstruct.ReportingPolicy;

@org.mapstruct.MapperConfig(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.WARN)
public interface MappingConfig {
}
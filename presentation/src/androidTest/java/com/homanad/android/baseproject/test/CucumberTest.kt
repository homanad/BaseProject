package com.homanad.android.baseproject.test

import cucumber.api.CucumberOptions

@CucumberOptions(
    features = ["features"], //features file folder name
    glue = ["com.homanad.android.project.base.cucumber.steps"], //path to cucumber steps folder
    tags = ["@production", "@development"] //separate test case's tag to execute
)
class CucumberTest
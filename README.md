# Bytecode Manipulation Project for Android

This project contains a simple bytecode manipulation plugin, its API and a sample android app that uses it. The project is configured with gradle. 

This project is structured around deploying the plugin to maven repos (this will make eventual publishing easier), therefore you need to execute a command in order to deploy to a local maven repo before the `sample_app` module can use the plugin. 

## Usage

Every time you change the plugin implementation and want to use the updated plugin inside your sample app, execute “./gradlew uploadArchives”. Next, build normally. 

**Upon downloading**, you must execute “./gradlew uploadArchives” at least once with “sample_app” removed from settings.gradle. After you’ve done this a local maven repo will be created with the plugin that can be used by “sample_app”.

node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/edport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/edport.git'), string(name: 'PORT_DESCRIPTION', value: 'GNU ed is a line-oriented text editor. It is used to create, display, modify and otherwise manipulate text files, both interactively and via shell scripts. A restricted version of ed, red, can only edit files in the current directory and cannot execute shell commands. Ed is the 'standard' text editor in the sense that it is the original editor for Unix, and thus widely available. For most purposes, however, it is superseded by full-screen editors such as GNU Emacs or GNU Moe.' ), string(name: 'BUILD_LINE', value: 'STABLE') ]
  }
}

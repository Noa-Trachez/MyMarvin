folder('Tools') {
    displayName('Tools')
    description('Folder for miscellaneous tools.')
}

freeStyleJob('Tools/clone-repository') {
    parameters {
        stringParam('GIT_REPOSITORY_URL', '', 'Git URL of the repository to clone')
    }
    wrappers {
        preBuildCleanup()
    }
    steps {
        shell('git clone ${GIT_REPOSITORY_URL}')
    }
}

freeStyleJob('Tools/SEED') {
    parameters {
        stringParam('GITHUB_NAME', '', 'GitHub repository owner/repo_name (e.g.: "EpitechIT31000/chocolatine")')
        stringParam('DISPLAY_NAME', '', 'Display name for the job')
    }
    steps {
        dsl {
            text('''job ("\$DISPLAY_NAME") {
                wrappers {
                    preBuildCleanup()
                }
                triggers {
                    scm('*/1 * * * *')
                }
                scm {
                    github("\$GITHUB_NAME")
                }
                steps {
                  shell("make fclean")
                  shell("make")
                  shell("make test_run")
                  shell("make clean")
                }
              }'''.stripIndent())
        }
    }
}

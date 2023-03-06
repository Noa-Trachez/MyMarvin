folder('Tools') {
    displayName('Tools')
    description('Folder for miscellaneous tools.')
}

freeStyleJob('Tools/clone-repository') {
    parameters {
        stringParam('REPOSITORY_URL', '', 'URL of the repository to clone.')
    }
    steps {
        shell('git clone ${REPOSITORY_URL}')
    }
    wrappers {
        preBuildCleanup()
    }
}


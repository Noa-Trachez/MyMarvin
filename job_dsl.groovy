folder('Tools') {
    displayName('Tools')
    description('Folder for miscellaneous tools.')
}

freeStyleJob('Tools/clone-repository') {
    parameters {
        stringParam('REPOSITORY_URL', ' ')
        description('URL of the repository to clone.')
    steps {
        shell('echo Hello World!')
    }
}

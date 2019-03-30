=================================================================================
https://github.com/StephenGrider/FullstackReactCode/issues/3
=================================================================================
About how to create .gitignore
You can reference the .gitignore template: Node.gitignore
'node_modules/' is added in this '.gitignore'

About how to remove node_modules
git rm -r --cached node_modules
git commit -m 'Remove the now ignored directory node_modules'
git push origin master
Then check your repository.

=================================================================================
=================================================================================
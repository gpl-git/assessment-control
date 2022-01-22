# **assessment-control** project

## How to push your changes to **GitHub**

### 1

Cut your own branch from `master` locally, typing:

```sh
git checkout -b name_of_your_branch
```

OR

```sh
git switch -c name_of_your_branch
```

if you already have some changes in the **working tree** and want not to wipe them out.

and create remote copy

```sh
git push --set-upstream origin name_of_your_branch
```

The name of your local branch must match the name of your remote branch.  
Example (You can see in terminal):

```
* [new branch] nik -> nik
```

### 2

Type

```sh
git branch
```

to verify that you created the branch (your currently branch will appear in green).

### 3

Make your changes.

### 4

Run

```sh
git status
```

(your changes will appear in red).

You can also use

```sh
git diff
```

to see a diff.

### 5

Add ALL your changes to staging (aka git index) by typing

```sh
git add .
```

OR

To add only SOME changes, instead `git add .` you can assign path to the file you want to commit after adding.  
Example (see [`man gitglossary`](https://git-scm.com/docs/gitglossary) about `pathspec` syntax):

```sh
git add ':/src/test/resources/features/1.ObjectsPropertiesMethods/firstTest.feature'
```

OR

Use the interactive mode:

```sh
git add -i
```

### 6

Type

```sh
git status
```

to check that you added all the changes (they will be shown in green).

You can also use

```sh
git diff --cached
```

to see a diff of the staged changes.

### 7

To add your changes from stage to your branch, type

```sh
git commit -m "[ADDED] your_message_explaining_what_you_modified"
```

Use different labels `[ADDED]` `[CHANGED]` `[IMPROVED]` `[FIXED]` `[DELETED]`
to better understand what you did on branch.

You could recheck the commit history typing

```sh
git log
```

### 8

Switch to master to update code on master branch:

```sh
git checkout master
```

And then:

```sh
git pull -r
```

### 9

Switch to your branch again:

```sh
git checkout name_of_your_branch
```

### 10

Type

```sh
git merge master
```

to make sure there won't be any conflicts in your future PR (Pull Request).

### 11

Run project to double-check if it is not broken.

### 12

If there is no conflicts, you can push to **GitHub**. Being on your branch, type

```sh
git push
```

### 13

Once you collected all the changes on your remote branch, you can go ahead and create a PR (Pull Request) on **GitHub**.

Repeat steps 1-13 for each complete task.

Or repeat steps 3-12 to update an existing task's PR.

### And more (optional)

```sh
git commit --amend
```

```sh
git rebase
```

```sh
git reflog
```

```sh
git reset
```

provide you with some powerful magic for rewriting commits history.

It should be done only on the history part that is still not pushed into upstream.
(Usually you REALLY DO NOT WANT to force-push: `git push -f`.)

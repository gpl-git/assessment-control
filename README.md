git assessment-control project

**How to push your changes to GitHub**
1
Cut your own branch from master locally:
**git checkout -b name_of_your_branch**
OR
**git switch -c name_of_your_branch**

2
To verify that you created the branch (your currently branch will appear in green)
**git branch**

3
Make changes in your branch

4
Run
**git status**
(Changed files will appear in red)

To see the difference, you can also use
**git diff**

5
Add ALL your changes to staging (git index)
**git add .**

6
To check that you added all the changes
**git status**
(Updated files will be shown in green)

7
To add your changes from stage to your branch, type
**git commit -m “message_text_explaining_what_was_modified"**

8
You could recheck the commit history by typing
**git log**

9
Switch to master to update code on master branch:
**git checkout master**
AND
**git pull**

10
Switch to your branch again:
**git checkout name_of_your_branch**

11
To make sure there won't be any conflicts in your future PR (Pull Request) run command
**git merge master**

12
Run project to double-check if it is not broken.

13
If there are no conflicts, you can push to GitHub. Being on your branch, type
**git push origin branch name_of_your_branch**

14
Create a PR (Pull Request) on GitHub.
Repeat steps 1-13 for each complete task.
Or repeat steps 3-12 to update an existing task's PR.

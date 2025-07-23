# travel-insurance_poc

## Travel_Plan as well as Plan_category based curd app through spring boot

```
<img width="1303" height="561" alt="image" src="https://github.com/user-attachments/assets/3566e5ad-6bf0-4083-9188-362af73db861" />

USER@fullstack MINGW64 /g/springboot_proj/travel_insurance_proj (master)
$ git status
On branch master
nothing to commit, working tree clean

USER@fullstack MINGW64 /g/springboot_proj/travel_insurance_proj (master)
$ ls -Force
ls: unknown option -- e
Try 'ls --help' for more information.

USER@fullstack MINGW64 /g/springboot_proj/travel_insurance_proj (master)
$ git push origin master
fatal: unable to connect to cache daemon: Unknown error
To https://github.com/deepsb-git/travel-insurance_poc.git
 ! [rejected]        master -> master (non-fast-forward)
error: failed to push some refs to 'https://github.com/deepsb-git/travel-insurance_poc.git'
hint: Updates were rejected because the tip of your current branch is behind
hint: its remote counterpart. If you want to integrate the remote changes,
hint: use 'git pull' before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.

USER@fullstack MINGW64 /g/springboot_proj/travel_insurance_proj (master)
$ git pull -rebase origin master
error: invalid value for '--rebase': 'ebase'

USER@fullstack MINGW64 /g/springboot_proj/travel_insurance_proj (master)
$ git fetch origin

USER@fullstack MINGW64 /g/springboot_proj/travel_insurance_proj (master)
$ git rebase origin/master
Successfully rebased and updated refs/heads/master.

USER@fullstack MINGW64 /g/springboot_proj/travel_insurance_proj (master)
$ git status
On branch master
nothing to commit, working tree clean

USER@fullstack MINGW64 /g/springboot_proj/travel_insurance_proj (master)
$ git add .

USER@fullstack MINGW64 /g/springboot_proj/travel_insurance_proj (master)
$ git rebase --continue
fatal: no rebase in progress

USER@fullstack MINGW64 /g/springboot_proj/travel_insurance_proj (master)
$ git pull --rebase origin master
From https://github.com/deepsb-git/travel-insurance_poc
 * branch            master     -> FETCH_HEAD
Current branch master is up to date.

USER@fullstack MINGW64 /g/springboot_proj/travel_insurance_proj (master)
$ git push origin master
fatal: unable to connect to cache daemon: Unknown error
Enumerating objects: 35, done.
Counting objects: 100% (35/35), done.
Delta compression using up to 8 threads
Compressing objects: 100% (27/27), done.
Writing objects: 100% (34/34), 12.47 KiB | 1.78 MiB/s, done.
Total 34 (delta 4), reused 0 (delta 0), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (4/4), done.
To https://github.com/deepsb-git/travel-insurance_poc.git
   eb1ac9f..097ba9c  master -> master

USER@fullstack MINGW64 /g/springboot_proj/travel_insurance_proj (master)
$


"# ktds-28-java-workspace" 

-- eclipse 자동완성
*생성자 자동완성
alt -> s -> a
alt + g

*Getter/Setter 자동완성
alt -> s -> r
alt + a
alt + r

-- git 세팅
1. github 계정 로그인

2. git-cmd에 입력
   ssh-keygen -t ed25519 -C "jangclara03@naver.com"
   이후 enter키 한 번, 패스워드 입력/설정

3. PowerShell
   Get-Service -Name ssh-agent | Set-Service -StartupType Manual
   Start-Service ssh-agent
   ssh-add C:\Users\User/.ssh/id_ed25519
   차례대로 입력 후 비밀번호 확인

   type C:\Users\User/.ssh/id_ed25519.pub
   입력하여 공개키 호출
   ex) 공개키
   ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIGP9euwJ43fMKQXton+zb/YvYp7aZeKn/lahw1EQfPmu jangclara03@naver.com

4. gitHub
   1 GitHub의 페이지 오른쪽 상단에서 프로필 사진을 선택한 다음,  Settings를 클릭
   2 사이드바의 "Access" 섹션에서  SSH and GPG keys를 클릭
   3 새 SSH 키 또는 SSH 키 추가를 클릭
   4 "제목" 필드에 새 키에 대한 설명이 포함된 레이블을 추가
   5 공개 키를 "키" 필드에 붙여 넣기 후 SSH 키 추가

git add .
git commit -m "20260720 실습 파일"
git push origin main --force
git push -f

-- 개발폰트
IBM Flex
Lucida console
Monaco
Fira Code
111111111(간격동일)
--> 한글 지원 X

D2Coding (네이버에서 제작)
--> 한글 지원 O

*패키지 이름 짓는 규칙
A회사 - 홈페이지 => https://exam.com
App 내부의 패키지 => 도메인의 역순 작성
-> com.exam
App 이름: "고객사 관리"
-> partner management
-> 패키지의 전체 이름: 도메인의 역순 + 업무의 이름
-> com.exam.partner
-> 전부 소문자로 작성
-> .(점)을 제외한 특수기호 사용 X
-> 숫자 사용 X

-- git rebase
git branch
git switch -c 장규나
git branch
git status
git add .
git commit -m "
git push -u origin 장규나

====충돌====

git switch main
git pull
git switch 장규나
git rebase origin/main
git branch
git status
git add .
git rebase --continue
git branch
git push -f



============
Esc -> :wq
============
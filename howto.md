1.Форкаем KotlinAsFirst2020
2.Клонируем KotlinAsFirst2020(clone)
3.Добавляем KotlinAsFirst2021 в качестве upstream-my
4.Фетчим KotlinAsFirst2021 (fetch)
5.Создаем ветвь backport, переходим в неё(сheckout -b)
6.Черри-пикаем нужные коммиты с апстрима (chery-pick)
7.Добавляем форк KotlinAsFirst2021 партнёра (Владислав "unrike" Емельянов) как upstream-theirs (remote add upstream-theirs)
8.Фетчим его его (fetch) и возращаемся в в ветку master.
9.Пытаемся замёрджить(merge)
10.Исправляем конфликты (mergetool)
11.Заканчиваем мердж
12.Добавляем необходимую информацию в remotes(remote -v)
13.Коммитим (commit)
14.Описываем в файле howto ход работы 
15.Коммитим (commit)
16.Пушим(push)
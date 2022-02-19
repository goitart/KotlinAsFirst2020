Сделал ворк KotlinAsFirst2020
Клонировал его
С помощью remote add добавил https://github.com/goitart/KotlinAsFirst2021
Выполнил команду git pull upstream-my
Получил сообщение:

You asked to pull from the remote 'upstream-my', but did not specify
a branch. Because this is not the default configured remote
for your current branch, you must specify a branch on the command line.

С помощью merge ситуация вроде поправилась (merge upstream-my/master)
Создал backport
C помощью cherry-pick перенес туда свои коммиты с решениями из 2021 года
Нашел себе пару - Чевычелова Александра
Добавил upstream-theirs (https://github.com/Uwncos/KotlinAsFirst2021.git)
Выполнил команду fetch upstream-theirs
Далее merge:
 merge -s ours upstream-theirs/master
ours - для разрешения конфликтов
Далее выполняю коммиты с этими файлами.
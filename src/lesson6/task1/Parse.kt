@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson6.task1

import kotlin.math.pow
import kotlin.math.sqrt

// Урок 6: разбор строк, исключения
// Максимальное количество баллов = 13
// Рекомендуемое количество баллов = 11
// Вместе с предыдущими уроками (пять лучших, 2-6) = 40/54

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main() {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        } else {
            println("Прошло секунд с начала суток: $seconds")
        }
    } else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}


/**
 * Средняя (4 балла)
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку.
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30.02.2009) считается неверными
 * входными данными.
 */
fun dateStrToDigit(str: String): String = TODO()

/**
 * Средняя (4 балла)
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30 февраля 2009) считается неверными
 * входными данными.
 */
fun dateDigitToStr(digital: String): String = TODO()

/**
 * Средняя (4 балла)
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -89 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку.
 *
 * PS: Дополнительные примеры работы функции можно посмотреть в соответствующих тестах.
 */
fun flattenPhoneNumber(phone: String): String = TODO()

/**
 * Средняя (5 баллов)
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int {
    val changedjump = "$jumps - "
    val pattern = Regex("""(\d+ |- |% )+""")
    if (pattern.matches(changedjump)) {
        val check = (jumps.split(" ").mapNotNull { it.toIntOrNull() }.maxOrNull())
        if (check != null) {
            return check
        }
    }
    return -1
}

/**
 * Сложная (6 баллов)
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки, а также в случае отсутствия удачных попыток,
 * вернуть -1.
 */
fun bestHighJump(jumps: String): Int = TODO()

/**
 * Сложная (6 баллов)
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
fun plusMinus(expression: String): Int {
    val changedexpr = "$expression + "
    var result: Int
    if (!Regex("""(\d+ ([+\-]) )+""").matches(changedexpr)) throw IllegalArgumentException(expression)
    val parts = expression.split(" ")
    result = parts[0].toInt()
    for (i in 0..parts.size - 1) {
        when (parts[i]) {
            "-" -> result -= parts[i + 1].toInt()
            "+" -> result += parts[i + 1].toInt()
        }
    }
    return result
}

/**
 * Сложная (6 баллов)
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int = TODO()

/**
 * Сложная (6 баллов)
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть больше нуля либо равны нулю.
 */
fun mostExpensive(description: String): String = TODO()
//    val parts = description.split(";")
//    var max = 0.0
//    val desc = "$description; "
////    if (Regex("""([А-Яа-яЁё]+ (\d+|\d+\.\d+); )+""").matches(desc)) {
////        val match =
////    }
//    return ""
//}

/**
 * Сложная (6 баллов)
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 *
 * Вернуть -1, если roman не является корректным римским числом
 */
fun fromRoman(roman: String): Int {
    val numbers = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1, 0)
    val romans = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I", "")
    var result = 0
    var iprev = "M"
    for (i in roman) {
        val j = i.toString()
        if (j !in "IMLCXVD") return -1
        val indexj = romans.indexOf(j)
        val indxiprev = romans.indexOf(iprev)
        if (numbers[indexj] > numbers[indxiprev]) {
            result += numbers[indexj] - numbers[indxiprev] - numbers[indxiprev]
        } else if (j in romans) {
            result += numbers[indexj]
        }
        iprev = j
    }
    if (result == 0) return -1 /* если result = 0, значит число не корректное*/
    return result
}

/**
 * Очень сложная (7 баллов)
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным символом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> = TODO()

//fun maxsumlist(list: String): List<Int> {
//    val listch = " $list,"
//    var result = listOf<Int>()
//    val values = mutableListOf<Int>()
//    val maxvalues = mutableListOf<Int>()
//    var max = 0
//    if (Regex("""(([ \-])+\d+,)+""").matches(listch)) {
//        val numbs = Regex("""((|-)+\d+)""").findAll(list)
//        numbs.forEach { f ->
//            val part = f.value
//            val intpart = part.toInt()
//            values += intpart
//        }
//        for (i in values.indices) {
//            maxvalues.add(values[i])
//            for (j in i+1..values.size - 1) {
//                maxvalues.add(values[j])
//                if (max <= maxvalues.sum()) {
//                    max = maxvalues.sum()
//                    result = maxvalues.toList()
//                }
//            }
//            maxvalues.clear()
//        }
//    } else throw IllegalArgumentException()
//    return result
//}
//fun pairs(list: String): MutableMap<Int, Int> {
//    var numberslist = mutableListOf<Int>()
//    val pairs1 = mutableMapOf<Int, Int>()
//    if (!Regex("""(\d+; )+""").matches(list)) throw IllegalArgumentException()
//    val numbs = Regex("""\d+""").findAll(list)
//    numbs.forEach { f ->
//        val part = f.value
//        val intpart = part.toInt()
//        numberslist.add(intpart)
//    }
//    for (i in 1..numberslist.size - 1) {
//        if (numberslist[i - 1] - numberslist[i] > 1 || numberslist[i] - numberslist[i - 1] > 1)
//            pairs1[maxOf(numberslist[i - 1], numberslist[i])] = minOf(numberslist[i - 1], numberslist[i])
//    }
//    for (i in 1..numberslist.size - 2) {
//        if (numberslist[i + 1] - numberslist[i] > 1 || numberslist[i] - numberslist[i + 1] > 1)
//            pairs1[maxOf(numberslist[i + 1], numberslist[i])] = minOf(numberslist[i + 1], numberslist[i])
//    }
//    print(numberslist)
//    return pairs1
//}
//fun football(text: String, list: List<String>): Map<String, Int> {
//    var score = mutableMapOf<String, Int>()
//    if (!Regex("""([а-яА-Я]+ \d+:\d+ [а-яА-Я]+; )+""").matches(text)) throw IllegalArgumentException()
//    var textlist = listOf<String>()
//    val matches = Regex("""[а-яА-я]+|\d+""").findAll(text)
//    matches.forEach { f ->
//        val part = f.value
//        textlist = textlist + part
//    }
//    for (i in 1..textlist.size - 2 step 4) {
//        if (textlist[i] > textlist[i + 1]) score[textlist[i - 1]] = 3
//        else if (textlist[i] < textlist[i + 1]) score[textlist[i + 2]] = 3
//        else if (textlist[i] == textlist[i + 1]) {
//            score[textlist[i - 1]] = 1
//            score[textlist[i + 2]] = 1
//        }
//    }
//    return score
//}
//fun tele(names: List<String>, digits: String): MutableList<String>{
//    val keyboard = mapOf(2 to "abc", 3 to "def", 4 to "ghi", 5 to "jkl", 6 to "mno", 7 to "pqrs", 8 to "tuv", 9 to "wxyz")
//    val keyboard1 = mutableMapOf<Char, Int>()
//    var flag = true
//    for ((key, value) in keyboard) {
//        for (l in value) {
//            keyboard1[l] = key
//        }
//    }
//    var word = ""
//    val result = mutableListOf<String>()
//    if (digits == "") return mutableListOf<String>()
//    for (name in names) {
//        for (letter in name) {
//            if (letter in keyboard1) word += keyboard1[letter]
//            else flag = false
//        }
//        if (word == digits && flag == true) result.add(name)
//        word = ""
//        flag = true
//    }
//    return result
//}


@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая (2 балла)
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val first = number / 1000
    val second = number / 100 - first * 10
    val fourth = number % 10
    val third = (number % 100 - fourth) / 10
    val summafs = first + second
    val summatf = fourth + third
    return when {
        (summafs == summatf) -> true
        else -> false
    }
}

/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */

fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    val biX = ((x1 - x2) * (x1 - x2))
    val biY = ((y1 - y2) * (y1 - y2))
    return when {
        x1 == x2 -> true
        y1 == y2 -> true
        biX == biY -> true
        else -> false
    }
}


/**
 * Простая (2 балла)
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    if (month == 1) {
        return (31)
    }
    if (month == 3) {
        return (31)
    }
    if (month == 4) {
        return (30)
    }
    if (month == 5) {
        return (31)
    }
    if (month == 6) {
        return (30)
    }
    if (month == 7) {
        return (31)
    }
    if (month == 8) {
        return (31)
    }
    if (month == 9) {
        return (30)
    }
    if (month == 10) {
        return (31)
    }
    if (month == 11) {
        return (30)
    }
    if (month == 12) {
        return (31)
    }
    if (month == 2) {
        if (year % 4 != 0) {
            return (28)
        }
        if (year % 100 != 0) {
            return (29)
        }
        if ((year % 400 != 0) and (year % 100 == 0)) {
            return (28)
        }
        if (year % 400 == 0) {
            return (29)
        }
    }
    return (-1)
}


/**
 * * Простая (2 балла)
 * *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    if (r2 < r1) {
        return false
    }
return ((sqr(x2 - x1) + sqr(y2 - y1)) <= sqr(r2 - r1))
}

/**
 * *Средняя (3 балла)
 * * *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * * * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 * */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean =
    (((a <= r) and (b <= s)) or ((a <= r) and (c <= s)) or ((a <= s) and (b <= r)) or ((a <= s) and (c <= r)) or ((c <= r) and (b <= s)) or ((c <= s) and (b <= r)))


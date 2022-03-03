@file:Suppress("UNUSED_PARAMETER")

package lesson1.task1

import java.lang.IllegalArgumentException
import kotlin.math.*

// Урок 1: простые функции
// Максимальное количество баллов = 5
// Рекомендуемое количество баллов = 4

/**
 * Пример
 *
 * Вычисление квадрата целого числа
 */
fun sqr(x: Int) = x * x

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun quadraticEquationRoot(a: Double, b: Double, c: Double) =
    (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double, b: Double, c: Double): Double {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}


/**
 * Тривиальная (3 балла).
 *
 * Задача имеет повышенную стоимость как первая в списке.
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
<<<<<<< .merge_file_a01660
fun seconds(hours: Int, minutes: Int, seconds: Int): Int {
    return hours * 3600 + minutes * 60 + seconds
}
=======
fun seconds(hours: Int, minutes: Int, seconds: Int): Int = hours * 3600 + minutes * 60 + seconds
>>>>>>> .merge_file_a04188

/**
 * Тривиальная (1 балл)
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 */
<<<<<<< .merge_file_a01660
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double {

    return vershoks * 0.04445 + arshins * 16 * 0.04445 + sagenes * 48 * 0.04445
}
=======
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double =
    (sagenes * 48 + arshins * 16 + vershoks) * 4.445 / 100
>>>>>>> .merge_file_a04188

/**
 * Тривиальная (1 балл)
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).
 */
<<<<<<< .merge_file_a01660
fun angleInRadian(deg: Int, min: Int, sec: Int): Double {
    val d = deg * 60 * 60
    val m = min * 60
    val exfinaldeg = d + m + sec
    val finaldeg = exfinaldeg.toDouble()
    val anglerad = finaldeg * PI/180/3600
    return anglerad
}
=======
fun angleInRadian(deg: Int, min: Int, sec: Int): Double = (deg * 3600 + min * 60 + sec).toDouble() / 3600 / 180 * PI
>>>>>>> .merge_file_a04188

/**
 * Тривиальная (1 балл)
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
<<<<<<< .merge_file_a01660

fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    val x11 = x1 - x2
    val y11 = y1 - y2
    val length = sqrt(x11 * x11 + y11 * y11)
    return length
}
=======
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double =
    sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))
>>>>>>> .merge_file_a04188

/**
 * Простая (2 балла)
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
<<<<<<< .merge_file_a01660
fun thirdDigit(number: Int): Int {
    return (number % 1000) / 100
}
=======
fun thirdDigit(number: Int): Int = number % 1000 / 100
>>>>>>> .merge_file_a04188

/**
 * Простая (2 балла)
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
<<<<<<< .merge_file_a01660
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int {
    return hoursArrive * 60 + minutesArrive - hoursDepart * 60 - minutesDepart
}
=======
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int =
    hoursArrive * 60 + minutesArrive - hoursDepart * 60 - minutesDepart
>>>>>>> .merge_file_a04188

/**
 * Простая (2 балла)
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */
<<<<<<< .merge_file_a01660
fun accountInThreeYears(initial: Int, percent: Int): Double {
    val per = percent * 0.01 + 1
    return initial * per * per * per
}
=======
fun accountInThreeYears(initial: Int, percent: Int): Double =
    initial * (1 + percent.toDouble() / 100) * (1 + percent.toDouble() / 100) * (1 + percent.toDouble() / 100)
>>>>>>> .merge_file_a04188

/**
 * Простая (2 балла)
 *
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int {
<<<<<<< .merge_file_a01660
    return (number % 10) * 100 + ((number / 10) % 10) * 10 + number / 100
}
=======
    val p = number / 100
    val t = number % 10
    val v = number % 100 / 10
    return t * 100 + v * 10 + p
}
>>>>>>> .merge_file_a04188

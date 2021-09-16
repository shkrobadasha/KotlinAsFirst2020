@file:Suppress("UNUSED_PARAMETER")

package lesson2.task1

import lesson1.task1.discriminant
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

// Урок 2: ветвления (здесь), логический тип (см. 2.2).
// Максимальное количество баллов = 6
// Рекомендуемое количество баллов = 5
// Вместе с предыдущими уроками = 9/12

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}

/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая (2 балла)
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    return when {
        (((age >= 11) and (age < 21)) or ((age >= 111) and (age < 121))) -> ("$age лет")
        (age % 10 == 1) -> ("$age год")
        ((age % 10 == 2) or (age % 10 == 3) or (age % 10 == 4)) -> ("$age года")
        else -> ("$age лет")

    }
}

/**
 * Простая (2 балла)
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(
    t1: Double, v1: Double,
    t2: Double, v2: Double,
    t3: Double, v3: Double
): Double {
    val way = v1 * t1 + v2 * t2 + v3 * t3
    val halfofway = way * 0.5
    val onepart = v1 * t1
    val secondpart = v2 * t2
    return when {
        halfofway <= onepart -> (halfofway / v1)
        ((halfofway > onepart) and (halfofway <= (secondpart + onepart))) -> ((halfofway - onepart)/v2 + t1)
        halfofway > secondpart -> ((halfofway - (onepart + secondpart))/v3 + t1 + t2)
        else -> 0.0
    }
}

/**
 * Простая (2 балла)
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(
    kingX: Int, kingY: Int,
    rookX1: Int, rookY1: Int,
    rookX2: Int, rookY2: Int
): Int {
    return when {
        (((kingX == rookX1) or (kingY == rookY1)) and ((kingX != rookX2) and (kingY != rookY2))) -> 1
        (((kingX == rookX2) or (kingY == rookY2)) and ((kingX != rookX1) and (kingY != rookY1))) -> 2
        (((kingX == rookX1) or (kingY == rookY1)) and ((kingX == rookX2) or (kingY == rookY2))) -> 3
        else -> 0
    }

}

/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(
    kingX: Int, kingY: Int,
    rookX: Int, rookY: Int,
    bishopX: Int, bishopY: Int
): Int {
    val biX = ((kingX - bishopX) * (kingX - bishopX))
    val biY = ((kingY - bishopY) * (kingY - bishopY))
    return when {
        (((kingX == rookX) or (kingY == rookY)) and (biX != biY)) -> 1
        (((kingX != rookX) and (kingY != rookY)) and (biX == biY)) -> 2
        (((kingX == rookX) or (kingY == rookY)) and (biX == biY)) -> 3
        else -> 0
    }
}

/**
 * Простая (2 балла)
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    if ((a + b > c) and (a + c > b) and (c + b > a)) {
        val coa = (b * b + c * c - a * a) / (2 * c * b)
        val cob = (-b * b + c * c + a * a) / (2 * c * a)
        val coc = (b * b - c * c + a * a) / (2 * a * b)
        if ((coa > 0) and (cob > 0) and (coc > 0)) return 0
        if ((coa == 0.0) or (cob == 0.0) or (coc == 0.0)) return 1
        if ((coa < 0) or (cob < 0) or (coc < 0)) return 2
    }
    return -1
}

/**
 * Средняя (3 балла)
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    if ((a <= c) and (b <= c)) {
        return -1
    }
    if ((a >= c) and (d <= a)) {
        return -1
    }

    if ((a <= c) and (b >= c)) {
        val crossing = b - c
        return crossing
    }

    if ((a >= c) and (a <= d)) {
        val cross = d - a
        return cross
    }
    if ((a >= c) and (b <= d)) {
        val crossq = b - a
        return crossq
    }
    if ((a <= c) and (b >= d)) {
        val crossw = d - c
        return crossw
    }
    if ((a <= c) and (b >= d)) {
        val crossw = d - c
        return crossw
    }
    return -1
}

@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import java.lang.Integer.min
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sqrt

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var num = n
    var counte = 0
    if (num <= 0) return 1
    while (num > 0) {
        if (num > 0)
            counte++
        num /= 10
    }
    return counte
}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int =
    when (n) {
        1 -> 1
        2 -> 1
        else -> fib(n - 1) + fib(n - 2)
    }

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (m in 2..n - 1) {
        if (n % m == 0) return m
    }
    return n
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var del = 1
    for (m in 2 until n - 1) {
        if (n % m == 0)
            del = m
    }
    return del
}

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var counte = 0
    var k = x
    while (k != 1)
        if (k != 1) {
            k = if (k % 2 == 0) {
                k / 2
            } else {
                k * 3 + 1
            }
            counte++
        }
    return counte
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var onenumber = m
    var twonumber = n
    while (onenumber != twonumber) {
        if (onenumber > twonumber) onenumber -= twonumber
        else twonumber -= onenumber
    }
    return m * n / onenumber
}


/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    val l = n * m
    var q = 0
    val x: Double
    sqrt(l.toDouble()).also { x = it }
    for (k in 2..x.toInt()) {
        if ((n % k == 0) and (m % k == 0)) {
            q = k
        }
    }
    if (q > 1) {
        return false
    }
    return true
}

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var nn = n
    var number = 0
    var ed = 0
    while (nn > 0) {
        ed = nn % 10
        number = number * 10 + ed
        nn /= 10
    }
    return number
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    val poly = n
    var nn = n
    var number = 0
    var ed = 0

    while (nn > 0) {
        ed = nn % 10
        number = number * 10 + ed
        nn /= 10
    }
    if (poly == number) {
        return true
    }
    return false
}

/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean = TODO()
/* {
    var count = 0
    (n / 10 == 0) ||

    var calculate = 0
    var n1 = n
    var n2 = n
    var q = 0
    var w = 0
    if (n1 % 10 == n) {
        return true
    } else {
        while (n1 > 0) {
            q = n1 % 10
            w = n1 % 100 - q
            if (q == w) {
                count++
            }
            n1 /= 10
        }
        while (n2 > 0) {
            calculate++
            n2 /= 10
        }
        if (count == calculate) {
            return true
        }
        return false
    }
} */

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var sumOfDigits = 0
    var nextNumber = 0 /*число, которое будем возводить в квадрат*/
    while (sumOfDigits < n) {
        nextNumber++ /*увеличиваем на один число, которое будем возводить в квадрат*/
        val nextSquare = nextNumber * nextNumber /*возводим очередное число в квадрат*/
        sumOfDigits += digitNumber(nextSquare) /*считаем количество цифр в возведенном только что числе и добавляем к сумме всех остальных*/
    }
    if (sumOfDigits == n) return ((nextNumber) * (nextNumber )) % 10/*если они равны, то мы выводим nextSquare %10*/
    else {
        var square = (nextNumber) * (nextNumber )
        var difference = sumOfDigits - n
        while (difference > 0) {
            square /= 10
            difference -= 1
        }
        return square % 10
    }

}

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var nextNumber = 0
    var sumOfDigits = 0
    while (sumOfDigits < n) {
        nextNumber++
        val fibonacciNumber = fib(nextNumber)
        sumOfDigits += digitNumber(fibonacciNumber)
    }
    if (sumOfDigits == n) return (fib(nextNumber)) % 10
    else {
        var square = fib(nextNumber)
        var difference = sumOfDigits - n
        while (difference > 0) {
            square /= 10
            difference -= 1
        }
        return square % 10
    }
}

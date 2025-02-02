@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import lesson5.task1.findSumOfTwo
import java.lang.Integer.min
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sqrt
import kotlin.math.max
import kotlin.math.min
import kotlin.math.abs

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
<<<<<<< .merge_file_a03764
    var num = abs(n)
    var count = 0
    if (num / 10 == 0) return 1
    while (num > 0) {
        count++
        num /= 10
    }
    return count
=======
    var result = 1
    var m = abs(n)
    while (m > 9) {
        m /= 10
        result += 1
    }
    return result
>>>>>>> .merge_file_a07236
}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    if(n == 1 || n == 2) return 1
    val listOfNumbers = mutableListOf(1, 1)
    for (i in 0..n - 3) {
        val fibResult = listOfNumbers[i] + listOfNumbers[i + 1]
        listOfNumbers.add(fibResult)
        //println()
    }
    return listOfNumbers.last()
}


/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
<<<<<<< .merge_file_a03764
    for (m in 2..n - 1) {
        if (n % m == 0) return m
    }
=======
    for (i in 2..n / 2 + 1)
        if (n % i == 0) return i
>>>>>>> .merge_file_a07236
    return n
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
<<<<<<< .merge_file_a03764

fun maxDivisor(n: Int): Int {
    for (m in n - 1 downTo 1) {
        if (n % m == 0) return m
    }
    return n
}

=======
fun maxDivisor(n: Int): Int {
    for (i in 2..sqrt(n.toDouble()).toInt())
        if (n % i == 0) return n / i
    return 1
}
>>>>>>> .merge_file_a07236

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
<<<<<<< .merge_file_a03764
    var count = 0
    var k = x
    while (k != 1) {
        if (k % 2 == 0) {
            k /= 2
        } else {
            k = k * 3 + 1
        }
        count++
    }
    return count
}

=======
    var p = x
    var result = 0
    while (p != 1) {
        result += 1
        if (p % 2 == 0) p /= 2
        else p = 3 * p + 1
    }
    return result
}
>>>>>>> .merge_file_a07236

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
<<<<<<< .merge_file_a03764
    var oneNumber = m
    var twoNumber = n
    while (oneNumber != twoNumber) {
        if (oneNumber > twoNumber) oneNumber -= twoNumber
        else twoNumber -= oneNumber
    }
    return m * n / oneNumber
}

=======
    for (i in max(m, n) until m * n step max(m, n)) if (i % m == 0 && i % n == 0) return i
    return m * n
}
>>>>>>> .merge_file_a07236

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
<<<<<<< .merge_file_a03764
    for (i in 2..(min(m, n))) {
        if (m % i == 0 && n % i == 0) {
            return false
        }
    }
=======
    for (i in 2..min(m, n)) if (m % i == 0 && n % i == 0) return false
>>>>>>> .merge_file_a07236
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
<<<<<<< .merge_file_a03764
    var nn = n
    var number = 0
    while (nn > 0) {
        number = number * 10 + nn % 10
        nn /= 10
    }
    return number
}

=======
    var p = n
    var result = 0
    while (p != 0) {
        val q = p % 10
        p /= 10
        result *= 10
        result += q
    }
    return result
}
>>>>>>> .merge_file_a07236

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
    val number = revert(n)
    return n == number
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
<<<<<<< .merge_file_a03764
    var sumOfDigits = 0
    var nextNumber = 0 /*число, которое будем возводить в квадрат*/
    while (sumOfDigits < n) {
        nextNumber++ /*увеличиваем на один число, которое будем возводить в квадрат*/
        val nextSquare = nextNumber * nextNumber /*возводим очередное число в квадрат*/
        sumOfDigits += digitNumber(nextSquare) /*считаем количество цифр в возведенном только что числе и добавляем к сумме всех остальных*/
    }
    var square = sqr(nextNumber)
    var difference = sumOfDigits - n
    while (difference > 0) {
        square = square.div(10)
        difference -= 1
    }
    return square % 10
}

=======
    var length = n
    var g: Long = 0
    var l = 1
    var m = 1
    var k: Long = 10
    while (length > 0) {
        g = ((m * m).toLong())
        while (g >= k) {
            k *= 10
            l += 1
        }
        length -= l
        m += 1
    }
    while (length != 0) {
        g /= 10
        length += 1
    }
    return (g % 10).toInt()
}
>>>>>>> .merge_file_a07236

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
<<<<<<< .merge_file_a03764
    var nextNumber = 0
    var sumOfDigits = 0
    while (sumOfDigits < n) {
        nextNumber++
        val fibonacciNumber = fib(nextNumber)
        sumOfDigits += digitNumber(fibonacciNumber)
    }

    var square = fib(nextNumber)
    var difference = sumOfDigits - n
    while (difference > 0) {
        square /= 10
        difference -= 1
    }
    return square % 10
}

=======
    if (n < 3) return 1
    var length = n - 2
    var e1: Long = 1
    var e2: Long = 1
    var g: Long = 0
    var k: Long = 10
    var l = 1
    while (length > 0) {
        g = e1 + e2
        if (e1 <= e2) e1 = g else e2 = g
        while (g >= k) {
            k *= 10
            l += 1
        }
        length -= l
    }
    while (length != 0) {
        g /= 10
        length += 1
    }
    return (g % 10).toInt()
}
>>>>>>> .merge_file_a07236

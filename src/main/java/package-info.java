/*
 * Singleton:   class Controller - чтобы иметь единственный экземпляр с глобальной точкой доступа
 * Factory:     Generator-классы, туда вынесена сложная логика создания
 * Builder:     class Person - собираем Person по частям в Билдере, так как много параметров
 * Adapter:     Не применён - не требуется
 * Bridge:      Не применён - не требуется
 * Facade:      В class InputProcessor - в class Person вынесли метод String build,
 *              который собирает Person внутри класса и не выносит логику наружу
 * DTO:         class Fio, Physical, Appearance - для уменьшения кода и обобщения
 * Шаблон:      abstract class Generator - заменил интерфейс на абстрактный класс. Сокращение кода, последовательность
 */
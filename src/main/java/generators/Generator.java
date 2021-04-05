package generators;

abstract class Generator<T> {

    public final T getParams(final int intCode) {
        generateParams(intCode);
        return buildResponse();
    }

    protected abstract void generateParams(int code);

    protected abstract T buildResponse();
}
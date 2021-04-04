package person;

import generators.AppearanceGenerator;
import generators.FioGenerator;
import generators.PhoneGenerator;
import generators.PhysGenerator;
import person.appearance.Appearance;

public final class Person {

    private String id;
    private Fio fio;
    private Physical phys;
    private Appearance appearance;
    private Phone phone;

    public String build(final String input) {
        return new Builder(input)
                .setFio()
                .setPhys()
                .setAppearance()
                .setPhone()
                .build()
                .toString();
    }

    public static final class Builder {
        private final String input;
        private final int intCode;
        private Fio fio;
        private Physical phys;
        private Appearance appearance;
        private Phone phone = null;

        private Builder(final String input) {
            this.input = input;
            this.intCode = Integer.parseInt(input);
        }

        private Builder setFio() {
            this.fio = new FioGenerator().getParams(intCode);
            return this;
        }

        private Builder setPhys() {
            this.phys = new PhysGenerator().getParams(intCode);
            return this;
        }

        private Builder setAppearance() {
            this.appearance = new AppearanceGenerator().getParams(intCode);
            return this;
        }

        private Builder setPhone() {
            // добавляем телефон, только если введённый код не палиндром
            if (!input.equals(new StringBuilder(input).reverse().toString())) {
                this.phone = new PhoneGenerator().getParams(intCode);
            }
            return this;
        }

        private Person build() {
            final Person person = new Person();
            person.id = this.input;
            person.fio = this.fio;
            person.phys = this.phys;
            person.appearance = this.appearance;
            person.phone = this.phone;
            return person;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(id).append("\n")
                .append(fio).append("\n")
                .append(phys).append("\n")
                .append(appearance).append("\n");
        if (phone != null) {
            sb.append(phone);
        } else {
            sb.append("Телефона нет");
        }
        return sb.toString();
    }
}
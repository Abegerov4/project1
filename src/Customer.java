class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer[Name=" + name + ", Email=" + email + "]";
    }
}
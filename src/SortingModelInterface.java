public interface SortingModelInterface {
    public void registerObserver(ArrayObserver o);
    public void removeObserver(ArrayObserver o);
    public void notifyObserver();

}

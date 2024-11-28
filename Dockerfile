FROM postgres:16-alpine
ENV POSTGRES_DB=bookstore
ENV POSTGRES_USER=kati
ENV POSTGRES_PASSWORD=kati
EXPOSE 8080
CMD ["postgres", "-p", "8080"]

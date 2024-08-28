FROM python:3.7.5-slim

ENV GIT_DISCOVERY_ACROSS_FILESYSTEM=1
RUN apt-get update
RUN apt-get install -y git
RUN git clone https://github.com/ishepard/pydriller.git
RUN echo '#!/bin/bash' >> test.sh && chmod +xw test.sh
RUN echo 'while :; do python pydriller1.py && sleep 60 && rm -r pydriller && git clone https://github.com/ishepard/pydriller.git; sleep 1; done' >> test.sh

COPY requirements.txt requirements.txt
RUN pip install -r requirements.txt

COPY pydriller1.py pydriller1.py
CMD ["./test.sh"]
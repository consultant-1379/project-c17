"""@inproceedings{Spadini2018,
  address = {New York, New York, USA},
  author = {Spadini, Davide and Aniche, Maur\'{i}cio and Bacchelli, Alberto},
  booktitle = {Proceedings of the 2018 26th ACM Joint Meeting on European Software Engineering Conference and Symposium on the Foundations of Software Engineering - ESEC/FSE 2018},
  doi = {10.1145/3236024.3264598},
  isbn = {9781450355735},
  keywords = {2018,acm reference format,and alberto bacchelli,davide spadini,git,gitpython,maur\'{i}cio aniche,mining software repositories,pydriller,python},
  pages = {908--911},
  publisher = {ACM Press},
  title = {{PyDriller: Python framework for mining software repositories}},
  url = {http://dl.acm.org/citation.cfm?doid=3236024.3264598},
  year = {2018}
}"""
import csv
from pydriller import Repository
with open('info.csv', 'w') as csvfile:
    fieldnames = ['Time','Commit','File']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
    writer.writeheader()
    ##for commit in Repository('https://github.com/src-d/hercules').traverse_commits():
    for commit in Repository('C:\PythonDev\GProject\project-c17').traverse_commits():
        ##print(commit.hash)
        ##print(commit.msg)
        ##print(commit.author.name)
        sm = commit.msg
        tdg = commit.committer_date
        print(commit.committer_date)

        for file in commit.modified_files:
            writer.writerow({'Time': tdg, 'Commit': sm, 'File': file.filename})
            print(file.filename, 'has changed')

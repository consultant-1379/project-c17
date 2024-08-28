#import sched, time, csv
#s = sched.scheduler(time.time, time.sleep)
import csv
from pydriller import Repository,Git
from datetime import datetime
from pydriller.metrics.process.change_set import ChangeSet



#def get_data(sc):
with open('info.csv', 'w') as csvfile:
    fieldnames = ['Time','Commit','File','Insertions','Deletions','Lines_Added','Lines_Removed','Maximum_Changeset','Average_Changeset','Authors']
    writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
    writer.writeheader()
    gr = Git('pydriller')
    metric = ChangeSet(path_to_repo='pydriller',
                    since=datetime(2021, 1, 1),
                    to=datetime(2021, 10, 22))


    maximum = metric.max()
    average = metric.avg()
    print("total =", maximum, " + ",average)
    for commit in Repository('pydriller').traverse_commits():
        sm = commit.msg
        tdg = commit.committer_date
        insertions = commit.insertions
        deletions = commit.deletions
        author = commit.author.name
        for file in commit.modified_files:
            writer.writerow({'Time': tdg, 'Commit': sm, 'File': file.filename, 'Insertions':insertions, 'Deletions':deletions,'Lines_Added': file.added_lines, 'Lines_Removed': file.deleted_lines ,
                         'Maximum_Changeset': maximum,'Average_Changeset':average,'Authors':author})
            print(file.filename, 'has changed')
#        s.enter(2,1,get_data,(sc,))
#s.enter(2,1,get_data, (s,))
#s.run()



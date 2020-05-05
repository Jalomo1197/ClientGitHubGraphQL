
import gitHubObject._
import Queries.RepoFilters._
import Queries.ProgramingLanguages._
import Queries.RequestType._
import Queries._


object ImportsTest extends App {
  val Github = (new Github).withAuthCode(client_data.GetAuthCodeFromConfig()).build
  val MyQuery = GithubQuery[QueryInfo]().withQueryType(MyRepos)
  val OptionReposList = Github.flatMap(MyQuery.build)
  val ReposList = OptionReposList.get
  val ScalaRepos = ReposList.filter(includeLanguages(List(Scala)))

  for (repo <- ScalaRepos){
    repo.printRepoInfo
  }
}

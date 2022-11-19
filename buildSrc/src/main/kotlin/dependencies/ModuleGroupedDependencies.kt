package dependencies
import core.ModulesDep

internal val featureModuleDependencies = listOf(
    ModulesDep.repoList,
    ModulesDep.repoDetails,
)

internal val featureModuleDependantDependencies = listOf(
    ModulesDep.di,
    ModulesDep.domain,
    ModulesDep.assets,
    ModulesDep.common,
    ModulesDep.navigation,
)
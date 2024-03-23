const solution = (skill, skill_trees) => {
    let availableCount = 0;

    const skillsObj = {};
    let skillTreeOrderArr = [];
    let anotherSkills = [];
    skill.split('').forEach((s, i) => {
        skillsObj[s] = i;
    });

    for (const skillTree of skill_trees) {
        const splitedSkillTree = skillTree.split('');

        for (const splitedSkillTreeElement of splitedSkillTree) {
            if(skillsObj.hasOwnProperty(splitedSkillTreeElement)) {
                if(skillsObj[splitedSkillTreeElement] === 0){
                    skillTreeOrderArr.push(splitedSkillTreeElement);
                    continue;
                }

                if(skillsObj[splitedSkillTreeElement] - skillsObj[skillTreeOrderArr[skillTreeOrderArr.length-1]] === 1) {
                    skillTreeOrderArr.push(splitedSkillTreeElement);
                    continue;
                } else {
                    anotherSkills = [];
                    skillTreeOrderArr = [];
                    break;
                }
            }
            anotherSkills.push(splitedSkillTreeElement);
        }

        if(anotherSkills.length + skillTreeOrderArr.length === splitedSkillTree.length) {
            availableCount++;
        }

        anotherSkills = [];
        skillTreeOrderArr = [];
    }

    return availableCount;
}

solution("CBD", ["BACDE", "CBADF", "AECB", "BDA"]);
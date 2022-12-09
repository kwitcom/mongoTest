This is a Test Only Application to test out MongoDB

There should be an array of viz_assets
- Some might be same type but will have different _id, assetId, biToolAssetId
- Some might have same workspaceId
- Some might have accessList with 0 or greater
  - Each Access record could be User which is internal or external of the Company Domain
  - Access Record could also be a Group

viz_group_Membership could be 1 of 3 types right now
- Google
- AAD
- External Contacts
Google and AAD groups will be related to an Access Record with link being email
Users that are members of one of these groups they will have the accessRole that is in the Access Record for the given group

viz_assets will have a property externalContactsShareAccessRole and when anything other than "NONE" should pull in member list of External Contacts Group TYPE
Users that are members of one of these groups they will have the accessRole which is set on externalContactsShareAccessRole


